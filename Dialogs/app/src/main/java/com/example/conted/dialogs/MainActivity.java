package com.example.conted.dialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        button=findViewById(R.id.button);

    }

    public void showAlertDialog1 (View view)
    {
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("This is my title");

        alertDialogBuilder.setPositiveButton("Yes",this);
        alertDialogBuilder.setNegativeButton("No",this);
        alertDialogBuilder.setNeutralButton("Cancel",this);

        AlertDialog alertDialog= alertDialogBuilder.create();
        alertDialog.show();
    }




        /// second approach
    public void showAlertDialog2 (View view)
    {
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Alert Dialog")
                .setMessage("Do you want to delete this file? ")
                .setCancelable(false)
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"File deleted",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No",null)
                .setNeutralButton("Cancel",null);
        alertDialogBuilder.show();


        alertDialogBuilder.setNegativeButton("No",this);
        alertDialogBuilder.setNeutralButton("Cancel",this);
        AlertDialog alertDialog= alertDialogBuilder.create();
        alertDialog.show();
    }


    public void showAlertDialog3 (View view)
    {
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Question? ")
                .setSingleChoiceItems(new String[]{"A", "B", "C", "D"}, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"index="+which,Toast.LENGTH_SHORT).show();
                    }
                });
        alertDialogBuilder.show();

    }


    public void showAlertDialog4 (View view)
    {
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Question? ")
                .setMultiChoiceItems(new String[]{"item1", "item2", "item3", "item4"}, new boolean[]{true, true, false, false},
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(MainActivity.this,"item "+which+" "+isChecked,Toast.LENGTH_SHORT).show();
                            }
                        });

                        alertDialogBuilder.show();




    }


    public void showProgressBar (View view)
    {
        final ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setTitle("progress dialog example");
        progressDialog.setMessage("please wait..");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(progressDialog.getProgress()< progressDialog.getMax())
                    progressDialog.incrementProgressBy(1);
                else progressDialog.dismiss();
            }
        },0,200);


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(progressDialog.getSecondaryProgress()<progressDialog.getMax())
                    progressDialog.incrementSecondaryProgressBy(1);
            }
        },0,140);

    }


    public void showCustomDialog(View view){
        Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.activity_main);
        dialog.show();
    }
    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which)
        {
            case DialogInterface.BUTTON_POSITIVE:
                System.out.println("Pressed ok button ");
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                System.out.println("Pressed no button ");
                break;
            case DialogInterface.BUTTON_NEUTRAL:
                System.out.println("Pressed cancel button ");
                break;
        }
    }
}
