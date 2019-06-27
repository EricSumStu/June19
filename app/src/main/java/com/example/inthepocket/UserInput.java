package com.example.inthepocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class UserInput extends AppCompatActivity implements Serializable {
    public static int counter;
    private static final String FILE_NAME = "test.txt";

    String name;
    Button submit;
    Button startTournament;
    EditText nameInput;
    ListView arrayDisplay;
    TextView displayCounter;
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
        startTournament = (Button) findViewById(R.id.StartTournament);


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
                    userArray.add(name);
                    userAdapter = new UserCustomAdapter(UserInput.this, R.layout.row,
                            userArray);
                    arrayDisplay.setAdapter(userAdapter);
                    //((EditText) findViewById(R.id.NameInput)).setText("");
                }

                displayCounter.setText("Players: " + userArray.size());
                ((EditText) findViewById(R.id.NameInput)).getText().clear();

                UserCustomAdapter.setOnDataChangeListener(new UserCustomAdapter.OnDataChangeListener() {
                    public void onDataChanged(int size) {
                        displayCounter.setText("Players: " + userArray.size());


                    }
                });
            }
        });

    }


    public void write(View v, ArrayList<String> userArray){
        String text = nameInput.getText().toString();
        FileOutputStream fos = null;
        OutputStreamWriter ow = null;
        try{
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            ow = new OutputStreamWriter(fos);

            for(String s : userArray) {
                ow.write(s + System.getProperty("line.separator"));
            }

            nameInput.getText().clear();
            Toast.makeText(this,"Saved to"+ getFilesDir()+ "/" +FILE_NAME,Toast.LENGTH_LONG).show();
        }catch(FileNotFoundException feo){
            feo.printStackTrace();

        }catch(IOException iow){
            iow.printStackTrace();

        }finally {
            try{
                if(ow !=null){
                    ow.close();
                    fos.close();
                }}catch(IOException ioa){
                ioa.printStackTrace();
            }
        }
    }
    public ArrayList<String> read(View v){
        FileInputStream fis = null;
        ArrayList<String> arrayListRead = new ArrayList<>();
        try{
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String s = null;
            StringBuilder sb = new StringBuilder();

            String reader;
            while( (reader = br.readLine()) != null)
            {
                arrayListRead.add(reader);
            }
            //redit.setText(arrayListRead.get(0));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
        return arrayListRead;
    }

    public void start_tournament(View view) {

        Random rand = new Random();
        Collections.shuffle(userArray, rand);

        write(view, userArray);


        startActivity(new Intent( UserInput.this, TournamentBracket.class));

        read(view);




    }
}
