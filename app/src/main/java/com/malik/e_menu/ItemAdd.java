package com.malik.e_menu;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ItemAdd extends AppCompatActivity {
    String[] one = {"Veg","Non-Veg"};
    String[] two = {"Chinese","Italian","Continental","NorthIndian","Mughlai","SouthIndian"};
    String[] three = {"Starters","Beverages","MainCourse","Desert","Rice&Bread"};
    String output;
    AutoCompleteTextView textView1,textView2,textView3;
    Spinner type_spinner,cuisine_spinner,category_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_add);
        final EditText item_code = (EditText)findViewById(R.id.itemCode);
        final EditText item_name = (EditText)findViewById(R.id.itemName);
        final EditText item_price = (EditText)findViewById(R.id.price);
        Button save_btn = (Button)findViewById(R.id.saveItem_btn);
        type_spinner=(Spinner)findViewById(R.id.type);
        category_spinner=(Spinner)findViewById(R.id.category);
        cuisine_spinner=(Spinner)findViewById(R.id.cuisine);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ItemAdd.this,android.R.layout.select_dialog_item,one);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        type_spinner.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,two);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cuisine_spinner.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,three);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        category_spinner.setAdapter(adapter2);
           /* show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    read();
                }

                public void read() {
                    sqliteDb db=new sqliteDb(ItemAdd.this);
                    SQLiteDatabase database=db.getWritableDatabase();
                    Cursor C = database.rawQuery("SELECT * FROM customer",null );
                    while (C.moveToNext()){
                        //output.append("Item Code: " + C.getString(0)+" \n" + "Item Name: "  + C.getString(1 ) + "\n" + "Item Price: " + C.getString(2) + " \n" + "Item Type: " + C.getString(3)+" \n" + "Category: "+ C.getString(4)+ " \n" + "Cuisine: "+ C.getString(5));
                    }
                    database.close();
                    C.close();
                }
            });*/
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }


            public void save(){
                String id= item_code.getText().toString();
                String name=item_name.getText().toString();
                name.replaceAll(" ","^^");
                String price=item_price.getText().toString();
                String category=category_spinner.getSelectedItem().toString();
                category.replaceAll(" ","^^");
                String type=type_spinner.getSelectedItem().toString();
                type.replaceAll(" ","^^");
                String cuisine=cuisine_spinner.getSelectedItem().toString();
                cuisine.replaceAll(" ","^^");
                new ItemAdd_Json(id,name,cuisine,category,type,price,ItemAdd.this).execute();

                /*
                String code = item_code.getText().toString();
                String name = item_name.getText().toString();
                String price= item_price.getText().toString();
                String Type = type_spinner.getSelectedItem().toString();
                Log.i("spintest",Type);
                String Category = category_spinner.getSelectedItem().toString();
                String Cuisine = cuisine_spinner.getSelectedItem().toString();
                DatabaseHelper databaseHelper=new DatabaseHelper(ItemAdd.this);
                boolean ret = databaseHelper.insertData(code,name,Type,Cuisine,Category,price);
                if(ret){
                    Toast.makeText(ItemAdd.this, "Data Added Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ItemAdd.this, "Data Not Added", Toast.LENGTH_SHORT).show();
                }
            }*/
            }
        });



    }
}
