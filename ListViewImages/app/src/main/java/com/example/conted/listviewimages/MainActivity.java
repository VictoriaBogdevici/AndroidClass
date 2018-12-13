package com.example.conted.listviewimages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeListView();
    }

    private void initializeListView() {
        ListView listView=findViewById(R.id.listView);
        AdapterView.OnItemClickListener itemClickListener=
                new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if(position==0) {
                            Intent intent= new Intent(MainActivity.this,DrinkCategoryActivity.class);
                            startActivity(intent);
                        }
                    }
                };
        listView.setOnItemClickListener(itemClickListener);
    }
}
