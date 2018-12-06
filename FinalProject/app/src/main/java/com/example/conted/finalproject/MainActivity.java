package com.example.conted.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText userAnswer;
    Button btValidate, btGenerate, btClear,btFinish,btScore,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,btMinus,btDot;
    TextView generatedText;

    int operation;
    StringBuilder myStr= new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        userAnswer = findViewById(R.id.userAnswer);

        btValidate = findViewById(R.id.btValidate);
        btValidate.setEnabled(false);
        btValidate.setOnClickListener(this);

        btGenerate = findViewById(R.id.btGenerate);
        btGenerate.setOnClickListener(this);

        btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(this);

        bt1=findViewById(R.id.bt1);
        bt1.setOnClickListener(numberButtonsListener);
        bt2=findViewById(R.id.bt2);
        bt2.setOnClickListener(numberButtonsListener);
        bt3=findViewById(R.id.bt3);
        bt3.setOnClickListener(numberButtonsListener);
        bt4=findViewById(R.id.bt4);
        bt4.setOnClickListener(numberButtonsListener);
        bt5=findViewById(R.id.bt5);
        bt5.setOnClickListener(numberButtonsListener);
        bt6=findViewById(R.id.bt6);
        bt6.setOnClickListener(numberButtonsListener);
        bt7=findViewById(R.id.bt7);
        bt7.setOnClickListener(numberButtonsListener);
        bt8=findViewById(R.id.bt8);
        bt8.setOnClickListener(numberButtonsListener);
        bt9=findViewById(R.id.bt9);
        bt9.setOnClickListener(numberButtonsListener);
        bt0=findViewById(R.id.bt0);
        bt0.setOnClickListener(numberButtonsListener);
        btMinus=findViewById(R.id.btMinus);
        btMinus.setOnClickListener(numberButtonsListener);
        btDot=findViewById(R.id.btDot);
        btDot.setOnClickListener(numberButtonsListener);

        generatedText = findViewById(R.id.generatedText);


    }

    View.OnClickListener numberButtonsListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            btValidate.setEnabled(true);
            int btId=view.getId();
            Button clicked=findViewById(btId);

            //check if "-" was pressed to put in in the front
            if(btId==R.id.btMinus){
                myStr.setCharAt(0,clicked.getText().toString().charAt(0));
            }
            else myStr.append(clicked.getText().toString());
            userAnswer.setText(myStr);
        }
    };




    // event handler for non numeric buttons
    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btGenerate:
                generate();
                break;
            case R.id.btClear:
                clear();
                break;
            case R.id.btFinish:
                finish();
                break;
            case R.id.btScore:
                showScore();
                break;
            case R.id.btValidate:
                validate();
                break;

        }
    }

    private void validate() {
        double userAnswerDouble= Double.valueOf(userAnswer.getText().toString());
        System.out.println(userAnswerDouble);


    }

    private void showScore() {
    }

    private void clear() {
        generatedText.setText("");
        userAnswer.setText("");
        myStr.setLength(0);
    }

    private void generate() {

        //generate the numbers
        Random rnd = new Random();
        int num1 = rnd.nextInt(10);
        int num2 = rnd.nextInt(10);
        System.out.println(num1 + " " + num2);

        //generate the operations

        operation = rnd.nextInt(4);
        switch (operation) {
            case 0:
                generatedText.setText(num1 + "+" + num2);
                break;
            case 1:
                generatedText.setText(num1 + "-" + num2);
                break;
            case 2:
                num2 = rnd.nextInt(9) + 1;
                generatedText.setText(num1 + "/" + num2);
                break;
            case 3:
                generatedText.setText(num1 + "*" + num2);
                break;

        }


    }
}
