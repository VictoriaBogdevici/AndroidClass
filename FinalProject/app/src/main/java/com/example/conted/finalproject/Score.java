package com.example.conted.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Score extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;
    RadioButton rbRight, rbWrong, rbAll, rbSortAsc, rbSortDesc;
    ListView myListView;
    ArrayList<Result> resultsList = new ArrayList<>();
    ArrayAdapter adapter;
    TextView scoreTextView;

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

        scoreTextView=findViewById(R.id.scoreTextView);
        scoreTextView.setText(getScoreText());


    }

    private String getScoreText() {
int rightPercentage= getRightPercentage();
      return "Right: "+rightPercentage+"%";
    }

    private int getRightPercentage() {
        double count=0;
        for(Result r: resultsList){
            if(r.isRight()) count++;
        }
        int rightPercent=(int)(count*100.00f/resultsList.size());
        return rightPercent;
    }

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

    private void sortDesc() {
    }

    private void sortAsc() {
    }

    private void getWrong() {
        ArrayList<Result> wrongList = new ArrayList<>();
        for (Result r : resultsList) {
            if (!r.isRight()) wrongList.add(r);
        }
        setList(wrongList);
    }



    private void getRight() {
        ArrayList<Result> rightList = new ArrayList<>();
        for (Result r : resultsList) {
            if (r.isRight()) rightList.add(r);
        }
        setList(rightList);
    }


    private void getAll() {
        setList(resultsList);
    }

    private void setList(ArrayList<Result> list) {
        adapter = new ArrayAdapter<Result>(this, R.layout.items_layout, R.id.textViewForList, list);
        myListView.setAdapter(adapter);
    }
}
