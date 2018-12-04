package com.example.conted.radiobuttonpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        radioGroup=findViewById(R.id.radioGroup);
        imageView=findViewById(R.id.imageView);
    }

    public void selection(View view) {
        int selectedId=radioGroup.getCheckedRadioButtonId();

        switch (selectedId)
        {
            case R.id.rb1: imageView.setImageResource(R.drawable.goofy_confused);
                break;
            case R.id.rb2: imageView.setImageResource(R.drawable.double_d);
                break;
            case R.id.rb3: imageView.setImageResource(R.drawable.eddy);
                break;
        }
    }
}
