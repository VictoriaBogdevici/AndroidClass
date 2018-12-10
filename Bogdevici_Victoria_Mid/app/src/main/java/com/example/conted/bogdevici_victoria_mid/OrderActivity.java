package com.example.conted.bogdevici_victoria_mid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewName,textViewOrder;
    Button btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initialize();
    }

    private void initialize() {

        Intent intent=getIntent();
        String name=intent.getStringExtra("Name");
        String order=intent.getStringExtra("Food");
        textViewName=findViewById(R.id.textViewName);
        textViewName.setText(name);

        textViewOrder=findViewById(R.id.textViewOrder);
        textViewOrder.setText(order);
        btBack=findViewById(R.id.btBack);
        btBack.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"Thank you for using our application "+textViewName.getText(),Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
