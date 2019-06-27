package com.example.inthepocket;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import java.io.IOException;

public class TournamentBracket extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(new CustomView(this));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
