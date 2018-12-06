package com.example.conted.multipageproject;

import android.content.Intent;
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
        double operand1=Double.valueOf(editText1.getText().toString());
        double operand2=Double.valueOf(editText2.getText().toString());

        int checkedRb=radioGroup.getCheckedRadioButtonId();
        double result;

        switch (checkedRb)
        {
            case R.id.rbAdd: result=operand1+operand2;
                break;
            case R.id.rbMultiply: result=operand1*operand2;
                break;
            case R.id.rbDivide: result=operand1/operand2;
                break;
            case R.id.rbSubstract: result=operand1-operand2;
                break;
                default: result=operand1+operand2;
        }
        System.out.println(result);

        Intent intent= new Intent(this,Main2Activity.class);

        intent.putExtra("result",String.valueOf(result));
        startActivity(intent);
    }
}
