package com.example.conted.listviewimages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        initializeListView();
    }

    private void initializeListView() {
        ListView listView= findViewById(R.id.listView);

        ArrayAdapter<Drink> listAdapter=new ArrayAdapter<>(this,R.layout.simple_list_item,Drink.drinks);

        listView.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener=
                new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(DrinkCategoryActivity.this,"position = "+ position+ ",id= "+id,Toast.LENGTH_SHORT);

                        Intent intent=new Intent (DrinkCategoryActivity.this,DrinkActivity.class);
                        intent.putExtra("id",)
                    }
                };
        listView.setOnItemClickListener(itemClickListener);
    }
}
