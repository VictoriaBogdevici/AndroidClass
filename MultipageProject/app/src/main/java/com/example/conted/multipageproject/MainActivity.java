package com.example.conted.multipageproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        radioGroup=findViewById(R.id.radioGroup);
    }


    public void operate(View view) {
        show();
    }



    public void close(View view) {
        finish();

    }

    private void show() {
        
    }
}
