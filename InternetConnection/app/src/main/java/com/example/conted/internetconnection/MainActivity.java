package com.example.conted.internetconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HttpURLConnectionProcessorInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void successHandler(String dataInXML) {

    }

    @Override
    public void failureHandler(Exception exception) {

    }
}
