package com.example.inthepocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;
import java.util.ArrayList;

public class UserInput extends AppCompatActivity implements Serializable {
    public static int counter;

    String name;
    Button submit;
    EditText nameInput;
    ListView arrayDisplay;
    public TextView displayCounter;
    public ArrayList<String> userArray = new ArrayList<String>();
    UserCustomAdapter userAdapter;

    public String getName() {
        return name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
        nameInput = (EditText) findViewById(R.id.NameInput);
        displayCounter = (TextView) findViewById(R.id.CounterNumber);
        arrayDisplay = (ListView) findViewById(R.id.listView);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                name = nameInput.getText().toString();


                if (userArray.contains(name)) {
                    Toast.makeText(getBaseContext(), "Username taken", Toast.LENGTH_LONG).show();
                } else if (name == null || name.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "ItemField Is Empty", Toast.LENGTH_LONG).show();
                } else if (userArray.size() == 8) {
                    Toast.makeText(UserInput.this, "Tournament full!!", Toast.LENGTH_LONG).show();
                } else {
//                    if (userArray.size() < 8) {
//                        counter++;
//                    } else {
//                        counter = 8;
//                    }
                    userArray.add(name);
                    userAdapter = new UserCustomAdapter(UserInput.this, R.layout.row,
                            userArray);
                    arrayDisplay.setAdapter(userAdapter);
                    System.out.println(counter);
                    System.out.println(userArray.size());
                }
                displayCounter.setText("Players: " + userArray.size());
                ((EditText) findViewById(R.id.NameInput)).getText().clear();

                UserCustomAdapter.setOnDataChangeListener(new UserCustomAdapter.OnDataChangeListener(){
                    public void onDataChanged(int size){
                        displayCounter.setText("Players: " + userArray.size());
                    }
                });
            }
        });
    }
}
