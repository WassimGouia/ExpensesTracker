package com.example.financetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    MainActivity2(){
        String text = "Hello, world!";
        dynamicText.setText(text);
        TextView dynamicText = findViewById(R.id.textView);
    }
}