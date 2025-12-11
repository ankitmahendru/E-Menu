package com.malik.e_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterClass extends BaseAdapter {

    ArrayList<String> name;
    ArrayList<String> price;
    ArrayList<ImageButton> btn1;
    ArrayList<ImageButton> btn2;
    ArrayList<EditText> Ed;
    int item = 0;

//    ArrayList<Button> btn;
    Context context;

    public AdapterClass(ArrayList<String> name, ArrayList<String> price,ArrayList<ImageButton> btn,ArrayList<ImageButton> btn1,ArrayList<EditText> Ed, Context context) {
        this.name = name;
        this.price = price;
        this.btn1=btn;
        this.btn2 = btn1;
        this.Ed = Ed;
        this.context = context;
    }

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.design,null);TextView n = (TextView)v.findViewById(R.id.name);

        n.setText(name.get(position));
        TextView p = (TextView)v.findViewById(R.id.price);
           p.setText(price.get(position));
           final EditText e = (EditText)v.findViewById(R.id.item_name);
           e.setText(String.valueOf(item));
          ImageButton btn=(ImageButton)v.findViewById(R.id.button);
           btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    if(item > 0) {
                        item--;
                       e.setText(String.valueOf(item));
                   }
                   else{
                      Toast.makeText(context, "Item Cannot Be Less Than Zero", Toast.LENGTH_SHORT).show();
                    }
               }
           });


            ImageButton btn1 = (ImageButton)v.findViewById(R.id.button2);
           btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   if (item < 10) {
                        item++;
                        e.setText(String.valueOf(item));
                   }
                   else{
                       Toast.makeText(context, "Quantity Limit Exceded", Toast.LENGTH_SHORT).show();
                   }
               }
            });


        return v;
    }
}
