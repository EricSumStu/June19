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
    //ListView userList;
    TextView displayCounter;
//    public ArrayList<String> Array = new ArrayList<String>();
    public ArrayList<String> userArray = new ArrayList<String>();
    UserCustomAdapter userAdapter;
    //private Intent intent;
    //ArrayList<String> userArray = new ArrayList<String>();


    public String getName() {
        return name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
//        Intent intent = new Intent(this, UserCustomAdapter.class);
//        intent.putExtra("arrayList", userArray);
//        startActivity(intent);
        counter = 0;
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
                } else if (counter == 8) {
                    Toast.makeText(UserInput.this, "Tournament full!!", Toast.LENGTH_LONG).show();
                } else {
                    if (counter < 8) {
                        counter++;
                    } else {
                        counter = 8;
                    }
                  //  Array.add(name);
                    userArray.add(name);
                     //System.out.println(userArray);
                    //ArrayAdapter<String> adapter = new ArrayAdapter<>(UserInput.this, android.R.layout.simple_list_item_1, Array);
                    userAdapter = new UserCustomAdapter(UserInput.this, R.layout.row,
                            userArray);
                    //arrayDisplay.setAdapter(adapter);
                    arrayDisplay.setAdapter(userAdapter);
                    //((EditText) findViewById(R.id.NameInput)).setText("");

                    System.out.println(userArray.size());
                }
                displayCounter.setText("Players: " + userArray.size());


            }
        });


//            userAdapter = new UserCustomAdapter(UserInput.this, R.layout.row,
//                    userArray);
//            arrayDisplay = (ListView) findViewById(R.id.listView);
//            arrayDisplay.setItemsCanFocus(false);
//            arrayDisplay.setAdapter(userAdapter);
//            /**
//             * get on item click listener
//             */
//            arrayDisplay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//                @Override
//                public void onItemClick(AdapterView<?> parent, View v,
//                                        final int position, long id) {
//                    Log.i("List View Clicked", "**********");
//                    Toast.makeText(UserInput.this,
//                            "List View Clicked:" + position, Toast.LENGTH_LONG)
//                            .show();
//                }
//            })
    }
}


//
//    public void onClick1(View view) {
//        startActivity(new Intent(UserInput.this, MainActivity.class));
//    }
//
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View row = null;
//        LayoutInflater inflater = getLayoutInflater();
//
//        row = inflater.inflate(R.layout.activity_user_custom_adapter, parent, false);
//
//        // inflate other items here :
//        Button deleteButton = (Button) row.findViewById(R.id.button2);
//        deleteButton.setTag(position);
//
//        deleteButton.setOnClickListener(
//                new Button.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Integer index = (Integer) arrayDisplay.getTag();
//                        userArray.remove(index.intValue());
//                        Array.remove(index.intValue());
//                        //notifyDataSetChanged();
//                    }
//                }
//        );
//        return null;
//    }
//}