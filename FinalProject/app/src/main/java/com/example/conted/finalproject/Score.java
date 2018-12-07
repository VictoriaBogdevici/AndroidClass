package com.example.conted.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class Score extends AppCompatActivity {
    ListView myListView;
    ArrayList<Result> resultsList = new ArrayList<>();
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
        ArrayAdapter adapter = new ArrayAdapter<Result>(this, R.layout.items_layout, R.id.textViewForList, resultsList);
        myListView.setAdapter(adapter);


    }
}
