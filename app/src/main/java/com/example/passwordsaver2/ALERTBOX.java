package com.example.passwordsaver2;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class ALERTBOX {
    public static AlertDialog.Builder GetALERTBOX(Context c, View v,String title,String message) {
        AlertDialog.Builder adb = new AlertDialog.Builder(c);
        adb.setView(v);
        adb.setTitle(title);
        adb.setMessage(message);
        adb.setIcon(android.R.drawable.ic_dialog_alert);
        return adb;
    }


}
