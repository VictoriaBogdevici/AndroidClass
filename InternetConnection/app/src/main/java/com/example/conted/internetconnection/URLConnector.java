package com.example.conted.internetconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class URLConnector extends AppCompatActivity implements View.OnClickListener,HttpURLConnectionProcessorInterface {


    TextView textViewData,textViewProgress;
    Button btLoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {

        textViewData= findViewById(R.id.textView2);
        textViewProgress=findViewById(R.id.textViewProgress);
        btLoad=findViewById(R.id.btLoad);

    }

    @Override
    public void onClick(View v) {
        String myURLString ="https://www.w3schools.com/xml/simple.xml";

        AsynchronousHttpURLConnector asynchronousHttpURLConnector=
                new AsynchronousHttpURLConnector(this,myURLString,textViewProgress);
        asynchronousHttpURLConnector.execute();
    }

    @Override
    public void successHandler(String dataInXML) {
        System.out.println("-----------> succesHandler: "+dataInXML);
        textViewData.setText(dataInXML);
    }

    @Override
    public void failureHandler(Exception exception) {
        System.out.println("failureHandler "+exception);
    }
}
