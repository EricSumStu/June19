package com.example.inthepocket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void create_new_tournament(View view) {
        startActivity(new Intent(MainActivity.this, UserInput.class));
    }

    public void view_available_tournaments(View view) {
        //new page for View Tournaments goes here
    }
    public void credits(View view) {
        //new page for View Tournaments goes here
    }
}
