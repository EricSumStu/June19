package com.example.inthepocket;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new HandleClick());
    }
    private class HandleClick implements View.OnClickListener {
        public void onClick(View arg0) {
            showWinners();
        }
    }
    private void showWinners(){

        LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.winners,null);

        float density=MainActivity.this.getResources().getDisplayMetrics().density;

        final PopupWindow pw = new PopupWindow(layout, (int)density*350, (int)density*450, true);

        ((Button) layout.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText4 = findViewById(R.id.editText4_main);
                String showString = editText4.getText().toString();

                pw.dismiss();
            }
        });

        pw.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        pw.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    pw.dismiss();
                    return true;
                }
                return false;
            }
        });
        pw.setOutsideTouchable(true);

        pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
    }

    public void onClick(android.view.View view) {
        // startActivity(new Intent(MainActivity.this, .class));
    }

    public void onClick2(android.view.View view) {
        //  startActivity(new Intent(MainActivity.this, CreditsPage.class));
    }

    public void onClick4(android.view.View view) {
        startActivity(new Intent(MainActivity.this, UserInput.class));
    }

    public void view_available_tournaments(View view) {
        //new page for View Tournaments goes here
        startActivity(new Intent(MainActivity.this, ViewTournaments.class));
    }
    public void credits(View view) {
        //new page for View Tournaments goes here
        startActivity(new Intent(MainActivity.this, CreditsPage.class));
    }
}
