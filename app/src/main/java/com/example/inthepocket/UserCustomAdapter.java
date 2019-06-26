
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

public class UserCustomAdapter extends ArrayAdapter<String> {


    Context context;
    int layoutResourceId;
    ArrayList<String> userArray = new ArrayList<String>();
    ListView arrayDisplay;


    public UserCustomAdapter(Context context, int layoutResourceId, ArrayList<String> String) {
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
            holder.textName = (TextView) row.findViewById(R.id.textView1);
            holder.btnDelete = (Button) row.findViewById(R.id.button2);
            row.setTag(holder);
        } else {
            holder = (UserHolder) row.getTag();
        }

        final String user = userArray.get(position);
        holder.textName.setText(user);
        holder.btnDelete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("Delete Button Clicked", "**********");
                Toast.makeText(context,  user + " has been deleted",
                        Toast.LENGTH_LONG).show();

                userArray.remove(user);
                notifyDataSetChanged();
                if(mOnDataChangeListener != null){
                    mOnDataChangeListener.onDataChanged(userArray.size());
                }
                //displayCounter.setText("Players: " + userArray.size());


            }
        });
        return row;
    }
    public interface OnDataChangeListener{
        public void onDataChanged(int size);
    }
    public static OnDataChangeListener mOnDataChangeListener;
    public static void setOnDataChangeListener(OnDataChangeListener onDataChangeListener){
        mOnDataChangeListener = onDataChangeListener;
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