package com.example.conted.multipageproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText editTextResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initialize();
        myGetIntent();
    }



    private void initialize() {
        editTextResult=findViewById(R.id.editTextResult);
    }

    private void myGetIntent() {
        Intent received= getIntent();
        String result= received.getStringExtra("result");
        editTextResult.setText(result);
    }
}
