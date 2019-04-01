package com.yeeyanhw1.bmi2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ed_weight;
    private EditText ed_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_weight = findViewById(R.id.ed_weight);
        ed_height = findViewById(R.id.ed_height);

        Button btn_help = findViewById(R.id.help);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI")
                        .setMessage(R.string.bmi_info)
                        .setPositiveButton(R.string.ok,null)
                        .show();
            }
        });
    }

    public void bmi(View view){
        String w = ed_weight.getText().toString();
        String h = ed_height.getText().toString();

        float wieght = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = wieght / (height * height);

        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("BMI", bmi);
        startActivity(intent);
    }
}
