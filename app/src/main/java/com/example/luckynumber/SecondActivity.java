package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView textView,textView2;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);

        //reciving data from Main Activity

        Intent i = getIntent();
        String userName= i.getStringExtra("name");

        //generating random numbers//
        int random_num = generatingRandomNumbers();
        textView2.setText(""+ random_num);
        //sharing the results//
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               shareData(userName,random_num);
            }
        });
    }
    public int generatingRandomNumbers(){
        Random random = new Random();
        int upperLImit= 1000;
        int randomNumberGenerated = random.nextInt(upperLImit);
        return generatingRandomNumbers();
    }
    public void shareData(String username,int random_num){
        //Implicit intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("/text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,username+"got luvky today");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is "+random_num);
        startActivity(Intent.createChooser(i,"choose a platfrom"));
    }
}