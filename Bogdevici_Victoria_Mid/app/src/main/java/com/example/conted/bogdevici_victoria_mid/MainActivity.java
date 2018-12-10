package com.example.conted.bogdevici_victoria_mid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;
    Button btFinish,btOrder;
    EditText editText;
    RadioButton rbPoutine, rbChefPoutine,rbSalmon,rbSushi,rbTacos;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        radioGroup = findViewById(R.id.radioGroup);
        btFinish=findViewById(R.id.btFinish);
        btFinish.setOnClickListener((View view) -> finish());

        btOrder=findViewById(R.id.btOrder);
        btOrder.setOnClickListener((View view) -> order());
        editText=findViewById(R.id.editText);
        imageView=findViewById(R.id.imgFood);

        rbPoutine=findViewById(R.id.rbPoutine);
        rbPoutine.setOnClickListener(this);

        rbChefPoutine=findViewById(R.id.rbChefPoutine);
        rbChefPoutine.setOnClickListener(this);

        rbSalmon=findViewById(R.id.rbSalmon);
        rbSalmon.setOnClickListener(this);

        rbSushi=findViewById(R.id.rbSushi);
        rbSushi.setOnClickListener(this);

        rbTacos=findViewById(R.id.rbTacos);
        rbTacos.setOnClickListener(this);


    }

    private void order() {
        Intent intent= new Intent(this,OrderActivity.class);
        intent.putExtra("Name",editText.getText().toString());

        RadioButton checked= findViewById(radioGroup.getCheckedRadioButtonId());

        intent.putExtra("Food",checked.getText().toString());
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();



        switch (id)
        {
            case R.id.rbPoutine: imageView.setImageResource(R.drawable.poutine);
                break;
            case R.id.rbChefPoutine: imageView.setImageResource(R.drawable.chefpoutine);
                break;
            case R.id.rbSalmon: imageView.setImageResource(R.drawable.salmon);
                break;
            case R.id.rbSushi: imageView.setImageResource(R.drawable.sushi);
                break;
                case R.id.rbTacos: imageView.setImageResource(R.drawable.tacos);
            break;

        }
    }
}
