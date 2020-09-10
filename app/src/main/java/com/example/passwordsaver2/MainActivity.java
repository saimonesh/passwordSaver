package com.example.passwordsaver2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView credentialListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        credentialListView=findViewById(R.id.DataListView);

        if(DatasCollection.getTotal()==0)
        {
            findViewById(R.id.nodata).setVisibility(View.VISIBLE);
        }
        else
        {
            findViewById(R.id.nodata).setVisibility(View.INVISIBLE);
            showDataCollection();
        }
    }

    private void showDataCollection() {
      HashMapAdapter adapter=new HashMapAdapter(DatasCollection.getDATA());
      credentialListView.setOnItemClickListener((adapterView, view, position, id) -> {
          try {
              Toast.makeText(this,"Selected Item +"+DatasCollection.getDATA(id).getName(),Toast.LENGTH_SHORT).show();
          }catch (Exception ex)
          {
           Toast.makeText(this,"Exception :"+ex.getMessage(),Toast.LENGTH_LONG );
          }

      });
      credentialListView.setAdapter(adapter);
    }

    public void gotoADDPage(View view)
    {
        Intent intent=new Intent(this,password_form.class);
        startActivity(intent);
    }
}