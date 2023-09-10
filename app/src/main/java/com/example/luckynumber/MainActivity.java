package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView LNA;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LNA = findViewById(R.id.LNA);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting name from editText//
                String userName = editText.getText().toString();
                //Explicit Intent

                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                //passing the name to second activity//
                i.putExtra("name",userName);
                startActivity(i);

            }
        });
    }

}