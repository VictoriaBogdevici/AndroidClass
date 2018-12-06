package com.example.conted.displaysum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText tf1,tf2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        initialize();
    }

    private void initialize() {
        tf1=findViewById(R.id.editText1);
        tf2=findViewById(R.id.editText2);



    }

  

    public void calculate(View view) {
        String input1=tf1.getText().toString();
        String input2=tf2.getText().toString();

        int nr1=Integer.valueOf(input1);
        int nr2=Integer.valueOf(input2);
        int sum=nr1+nr2;

        //show the result
        Toast.makeText(this,String.valueOf(sum),Toast.LENGTH_LONG).show();
    }
}
