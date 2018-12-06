package com.example.conted.studentmultipage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 Button btAdd,btRemove,btShow,btClear;
 EditText studentId,studentName,studentAge;

 ArrayList<Student> listOfStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initialize();
    }

    private void initialize() {

        listOfStudents=new ArrayList<>();

        btAdd=findViewById(R.id.btAdd);
        btAdd.setOnClickListener(this);

        btRemove=findViewById(R.id.btRemove);
        btRemove.setOnClickListener(this);

        btShow=findViewById(R.id.btShow);
        btShow.setOnClickListener(this);

        btClear=findViewById(R.id.btClear);
        btClear.setOnClickListener(this);

        studentId=findViewById(R.id.studentID);
        studentName=findViewById(R.id.studentName);
        studentAge=findViewById(R.id.studentAge);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btAdd:
                add();
                break;
            case R.id.btClear:
                clear();
                break;
            case R.id.btRemove:
                finish();
                break;
            case R.id.btShow:
                show();
                break;


        }
    }

    private void clear() {
    }

    private void add() {
    }

    private void show() {
    }


}
