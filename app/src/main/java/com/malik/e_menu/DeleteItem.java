package com.malik.e_menu;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteItem extends AppCompatActivity {
    Button search_btn2, del_btn, del_all_btn;
    EditText search_id2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item);
        search_btn2 = (Button) findViewById(R.id.search_btn2);
        del_all_btn = (Button) findViewById(R.id.del_all_btn);
        del_btn = (Button) findViewById(R.id.del_btn1);
        search_id2 = (EditText) findViewById(R.id.search_id2);
        textView = (TextView) findViewById(R.id.display);
        del_all_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DeleteItem.this);
                builder
                        .setMessage("Are you sure?")
                        .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // Yes-code
                                Cursor res =new DatabaseHelper(DeleteItem.this).getAllData();
                                if(res.getCount() == 0) {
                                    // show message
                                    AlertDialog.Builder builder = new AlertDialog.Builder(DeleteItem.this);
                                    builder.setCancelable(true);
                                    builder.setTitle("Error");
                                    builder.setMessage("No Records Found");
                                    builder.show();
                                    return;
                                }
                                SQLiteDatabase db= new DatabaseHelper(DeleteItem.this).getWritableDatabase();
                                db.execSQL("delete from "+DatabaseHelper.TABLE_NAME);
                                Toast.makeText(DeleteItem.this, "All Items Deleted", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();
               }
        });
        search_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = search_id2.getText().toString();
                new DeleteItem_JSON(id,DeleteItem.this).execute();
            /*
                final String searchid = search_id2.getText().toString();
                DatabaseHelper db = new DatabaseHelper(DeleteItem.this);
                db.getWritableDatabase();
                final SQLiteDatabase database = db.getWritableDatabase();
                Cursor isfound = database.rawQuery("SELECT * from ItemTable WHERE ID =" + searchid, null);
                if (isfound.moveToFirst()) {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("Id :" + isfound.getString(0) + "\n");
                    buffer.append("Name :" + isfound.getString(1) + "\n");
                    buffer.append("Type :" + isfound.getString(2) + "\n");
                    buffer.append("Cuisine :" + isfound.getString(3) + "\n");
                    buffer.append("Category :" + isfound.getString(4) + "\n");
                    buffer.append("Price :" + isfound.getString(5) + "\n\n");
                    textView.setText(buffer.toString());
                    del_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Integer deletedRows = new DatabaseHelper(DeleteItem.this).deleteData(search_id2.getText().toString());
                            if (deletedRows > 0){
                                textView.setText(null);
                                Toast.makeText(DeleteItem.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        }
                            else
                                Toast.makeText(DeleteItem.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    Toast.makeText(DeleteItem.this, "Item Not Found", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

    }
}
