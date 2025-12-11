package com.malik.e_menu;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UpdateItem extends AppCompatActivity {
    EditText id,name,price;
    String[] types = {"Veg","Non-Veg"};
    String[] cuisines = {"Chinese","Italian","Continental","NorthIndian","Mughlai","SouthIndian"};
    String[] Categories = {"Starters","Beverages","MainCourse","Desert","Rice&Bread"};
    Spinner type,cuisine,category;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);
        type= (Spinner) findViewById(R.id.type);
        cuisine= (Spinner) findViewById(R.id.cuisine);
        category= (Spinner) findViewById(R.id.category);
        id=(EditText) findViewById(R.id.search_id);
        name=(EditText) findViewById(R.id.item_name);
        price=(EditText) findViewById(R.id.item_price);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,types);
        type.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,cuisines);
        cuisine.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,Categories);
        category.setAdapter(adapter2);
        update=(Button)findViewById(R.id.update_btn);
        type.setVisibility(View.VISIBLE);
        name.setVisibility(View.VISIBLE);
        category.setVisibility(View.VISIBLE);
        cuisine.setVisibility(View.VISIBLE);
        update.setVisibility(View.VISIBLE);
        price.setVisibility(View.VISIBLE);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UpdateItem.this, "Clicked", Toast.LENGTH_SHORT).show();
                new UpdateItem_JSON(id.getText().toString(),name.getText().toString(),
                        cuisine.getSelectedItem().toString(),category.getSelectedItem().toString(),
                        type.getSelectedItem().toString(),price.getText().toString(),UpdateItem.this).execute();
            }
        });
        /*search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String searchid=id.getText().toString();
                DatabaseHelper db=new DatabaseHelper(UpdateItem.this);
                db.getWritableDatabase();
                final SQLiteDatabase database=db.getWritableDatabase();
                Cursor isfound = database.rawQuery("SELECT * from ItemTable WHERE ID ="+searchid,null);
                if(isfound.moveToFirst()) {
                    type.setVisibility(View.VISIBLE);
                    name.setVisibility(View.VISIBLE);
                    category.setVisibility(View.VISIBLE);
                    cuisine.setVisibility(View.VISIBLE);
                    update.setVisibility(View.VISIBLE);
                    price.setVisibility(View.VISIBLE);
                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Boolean isUpdated =new DatabaseHelper(UpdateItem.this).updateData(searchid, name.getText().toString(), type.getSelectedItem().toString()
                                    , cuisine.getSelectedItem().toString(), category.getSelectedItem().toString(), price.getText().toString());
                            if (isUpdated) {
                                Toast.makeText(UpdateItem.this, "Item Updated Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(UpdateItem.this, "Updation Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(UpdateItem.this, "Item Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }
}
