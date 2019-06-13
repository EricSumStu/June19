package com.example.inthepocket;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class UserInput extends AppCompatActivity {
    public static int counter = 0;
    String name;
    Button button;
    EditText nameInput;
    ListView arrayDisplay;
    TextView displayCounter;
    ArrayList<String> Array = new ArrayList<String>();

    //going from page to page
    public void onClick1(View view) {
        startActivity(new Intent(UserInput.this, MainActivity.class));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

        nameInput = (EditText) findViewById(R.id.NameInput);
        displayCounter = (TextView) findViewById(R.id.CounterNumber);
        arrayDisplay = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 name = nameInput.getText().toString();

                if (Array.contains(name)) {
                    Toast.makeText(getBaseContext(), "Username taken", Toast.LENGTH_LONG).show();
                } else if (name == null || name.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "ItemField Is Empty", Toast.LENGTH_LONG).show();
                } else if (counter == 10) {
                    Toast.makeText(UserInput.this, "Tournament full!!", Toast.LENGTH_LONG).show();
                } else {
                    if (counter < 10){
                        counter++;
                    }else{
                        counter = 10;
                    }
                    Array.add(name);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(UserInput.this, android.R.layout.simple_list_item_1, Array);
                    arrayDisplay.setAdapter(adapter);
                    ((EditText) findViewById(R.id.NameInput)).setText("");
                }
                displayCounter.setText("Players: " + counter);
            }
        });
    }
}



