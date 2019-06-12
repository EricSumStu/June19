package com.example.inthepocket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

    }
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, UserInput.class));
    }

    public void onClick1(View view) {
        //new page for View Tournaments goes here
    }
}
