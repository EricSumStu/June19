
package com.example.inthepocket;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class UserCustomAdapter extends ArrayAdapter<User> {


    Context context;
    int layoutResourceId;
    ArrayList<User> userArray = new ArrayList<User>();
    ListView arrayDisplay;


    public UserCustomAdapter(Context context, int layoutResourceId, ArrayList<User> String) {
        super(context, layoutResourceId, String);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.userArray = String;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        UserHolder holder = null;


        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new UserHolder();
            holder.textName = row.findViewById(R.id.textView1);
            holder.btnDelete = row.findViewById(R.id.button2);
            row.setTag(holder);
        } else {
            holder = (UserHolder) row.getTag();
        }

        User user = userArray.get(position);
        holder.textName.setText(user.getName());
        final View finalRow = row;
        holder.btnDelete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("Delete Button Clicked", "**********");
                Toast.makeText(context, "Delete button Clicked- tough luck learn to live with your mistakes " + v.findViewById(R.id.button),
                        Toast.LENGTH_LONG).show();
                Button deleteButton = finalRow.findViewById(R.id.button2);
                deleteButton.setTag(position);

                deleteButton.setOnClickListener(
                        new Button.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                               // Integer index = (Integer) arrayDisplay.getTag();
                         //       userArray.remove(index.intValue());
                             //   Array.remove(index.intValue());
                                //notifyDataSetChanged();
                            }
                        }
                );
                //System.out.println(userArray);
            }
        });
        return row;

    }


    static class UserHolder {
        TextView textName;
        Button btnDelete;
    }
}




/*
    Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);
    Button addBtn = (Button)view.findViewById(R.id.add_btn);

    deleteBtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //do something
            list.remove(position); //or some other task
            notifyDataSetChanged();
        }
    });


    public void delete(View v){

    ListView listview1;
    ArrayList<E> datalist;

    final int position = listview1.getPositionForView((View) v.getParent());
    datalist.remove(position);
    myAdapter.notifyDataSetChanged();

}
 */