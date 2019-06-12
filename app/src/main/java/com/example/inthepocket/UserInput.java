package com.example.inthepocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserInput extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.InThePocket.MESSAGE";

    String name;
    Button button;

    EditText nameInput;
    TextView displayName;

    private void showToast(String text) {
        Toast.makeText(UserInput.this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = (EditText) findViewById(R.id.NameInput);
        displayName = (TextView) findViewById(R.id.editText);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();

                showToast(name);
                displayName.setText(name);

            }
        });
    }
}

/*

public class MyClass {
  public static void main(String[] args) {
    ArrayList<String> players = new ArrayList<String>();
    players.add(message)
    System.out.println(message);//ArrayList
  }
}

 */



