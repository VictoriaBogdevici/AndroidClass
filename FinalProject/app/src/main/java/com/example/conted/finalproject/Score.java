package com.example.conted.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Score extends AppCompatActivity implements View.OnClickListener {
    RadioGroup radioGroup;
    RadioButton rbRight, rbWrong, rbAll, rbSortAsc, rbSortDesc;
    ListView myListView;
    ArrayList<Result> resultsList = new ArrayList<>();
    ArrayAdapter adapter;
    TextView scoreTextView;
    Button btBack;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        initialize();
    }

    private void initialize() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("myBundle");
        Serializable receivedObject = bundle.getSerializable("resultsList");
        resultsList = (ArrayList<Result>) receivedObject;

        myListView = findViewById(R.id.myListView);
        setList(resultsList);

        radioGroup = findViewById(R.id.radioGroup);

        rbAll = findViewById(R.id.rbAll);
        rbAll.setOnClickListener(this);
        rbRight = findViewById(R.id.rbRight);
        rbRight.setOnClickListener(this);
        rbWrong = findViewById(R.id.rbWrong);
        rbWrong.setOnClickListener(this);
        rbSortAsc = findViewById(R.id.rbSortAsc);
        rbSortAsc.setOnClickListener(this);
        rbSortDesc = findViewById(R.id.rbSortDesc);
        rbSortDesc.setOnClickListener(this);

            //initialize score text view and set the score text
        scoreTextView=findViewById(R.id.scoreTextView);
        scoreTextView.setText(getScoreText());

            //initialize Back method and activate event listener
        btBack=findViewById(R.id.btBack);
        btBack.setOnClickListener((View view)-> goBack());

        editTextName=findViewById(R.id.editTextName);


    }

      // method for back button
    private void goBack() {
        Intent intent= new Intent(this,MainActivity.class);
        intent.putExtra("Name",editTextName.getText().toString());
        intent.putExtra("Score",scoreTextView.getText().toString());
        startActivity(intent);

    }


    // method when back arrow pressed (override so it behaves like back from UI)
    @Override
    public void onBackPressed() {

        goBack();
    }


    // creating the score text to be displayed
    private String getScoreText() {
int rightPercentage= getRightPercentage();
      return "Right: "+rightPercentage+"%";
    }

     //computing the right answers percentage
    private int getRightPercentage() {
        double count=0;
        for(Result r: resultsList){
            if(r.isRight()) count++;
        }
        int rightPercent=(int)(count*100.00f/resultsList.size());
        return rightPercent;
    }


    //event listener for radio buttons
    @Override
    public void onClick(View v) {
        int id = radioGroup.getCheckedRadioButtonId();

        switch (id) {
            case R.id.rbAll:
                getAll();
                break;
            case R.id.rbRight:
                getRight();
                break;
            case R.id.rbWrong:
                getWrong();
                break;
            case R.id.rbSortAsc:
                sortAsc();
                break;
            case R.id.rbSortDesc:
                sortDesc();
                break;


        }
    }

   // ---------------------------------------RADIO BUTTONS METHODS -----------------------------------
    //sorting right answers first
    private void sortDesc() {
        ArrayList<Result> sortedDesc = new ArrayList<>(resultsList);
        Collections.sort(sortedDesc,(Result r1, Result r2)-> {
            if(r1.isRight()) return 1;
            else return  -1;
        });
        setList(sortedDesc);
    }
    //sorting wrong answers first
    private void sortAsc() {
        ArrayList<Result> sortedAsc = new ArrayList<>(resultsList);
        Collections.sort(sortedAsc,(Result r1, Result r2)-> {
            if(r1.isRight()) return -1;
            else return  1;
        });
        setList(sortedAsc);
    }
    //returning all wrong answers
    private void getWrong() {
        ArrayList<Result> wrongList = new ArrayList<>();
        for (Result r : resultsList) {
            if (!r.isRight()) wrongList.add(r);
        }
        setList(wrongList);
    }
    //returning all right answers
    private void getRight() {
        ArrayList<Result> rightList = new ArrayList<>();
        for (Result r : resultsList) {
            if (r.isRight()) rightList.add(r);
        }
        setList(rightList);
    }
    // returning all answers
    private void getAll() {
        setList(resultsList);
    }


    // binding the listView with arraylist
    private void setList(ArrayList<Result> list) {
        adapter = new ArrayAdapter<Result>(this, R.layout.items_layout, R.id.textViewForList, list);
        myListView.setAdapter(adapter);
    }



}
