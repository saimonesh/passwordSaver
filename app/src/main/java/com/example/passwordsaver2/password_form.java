package com.example.passwordsaver2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class password_form extends AppCompatActivity {

    EditText description, userName, password, Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_form);
        description = findViewById(R.id.description);
        userName = findViewById(R.id.username);
        password = findViewById(R.id.passowrd);
        Title = findViewById(R.id.Name);
    }

    public void ADD(View view) {
        DATA d = getDataFromUI();
        try {
            checkvalid(d);
            if (DatasCollection.addData(d)) {
                AlertDialog.Builder b = ALERTBOX.GetALERTBOX(this, view, "SUCCESS ADDED", "ADDED DETAILS of " + d.getName() + ".Do You want to add More");
                b.setPositiveButton("YES", (dialog, which) -> {
                    resetALL();
                });
                b.setNegativeButton("NO", (dialog, which) -> {

                });
                Toast.makeText(this, "ADDED DETAILS of " + d.getName(), Toast.LENGTH_SHORT).show();
                resetALL();
            }
            Toast.makeText(this, "Total List Contains : " + DatasCollection.getTotal(), Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private DATA getDataFromUI() {
        return new DATA(Title.getText().toString(), userName.getText().toString(), password.getText().toString(), description.getText().toString());
    }

    public void GOBACK(View v) {
        DATA d = getDataFromUI();
        if (!checkTitleEmpty(d) || !checkNameEmpty(d) || !checkpasswordEmpty(d) || !checkDescriptionEmpty(d)) {
            try {
                if (DatasCollection.getDATA(d.ID) == null) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                    alertDialogBuilder.setMessage("All unsaved values will be discarded.Do you want to proceed further");
                    alertDialogBuilder.setPositiveButton("yes",
                            (arg0, arg1) -> {
                                resetALL();
                                GotoMainPage();
                            });

                    alertDialogBuilder.setNegativeButton("No", (dialog, which) -> {});

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else {
            GotoMainPage();
        }


    }

    private void GotoMainPage() {
        startActivity(new Intent(this, MainActivity.class));
    }


    private void resetALL() {
        Title.setText("");
        userName.setText("");
        password.setText("");
        description.setText("");
    }

    private void checkvalid(DATA d) throws Exception {
        if (d != null) {
            if (checkTitleEmpty(d) || checkNameEmpty(d) || checkpasswordEmpty(d)) {
                throw new Exception("Please Enter Mandatory Fields (*) ");
            }
        }
    }

    private boolean checkDescriptionEmpty(DATA d) {
        if (d.getDescription() == null || d.getDescription().length() == 0)
            return true;
        return false;
    }

    private boolean checkpasswordEmpty(DATA d) {
        if (d.isPasswordEmpty()) {
            return true;
        }
        return false;
    }

    private boolean checkNameEmpty(DATA d) {
        if (d.getUserName() == null || d.getUserName().length() == 0) {
            return true;
        }
        return false;
    }

    private boolean checkTitleEmpty(DATA d) {
        if (d.getName() == null || d.getName().length() == 0) {
            return true;
        }
        return false;
    }

}