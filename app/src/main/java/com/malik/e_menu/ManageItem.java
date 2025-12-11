package com.malik.e_menu;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ManageItem extends AppCompatActivity {
    Button back_btn,add_itm_btn,upd_itm_btn,view_item_btn,del_item_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_item);
        back_btn=(Button)findViewById(R.id.back_btn);
        add_itm_btn=(Button)findViewById(R.id.add_itm_btn);
        del_item_btn=(Button)findViewById(R.id.del_itm_btn);
        upd_itm_btn=(Button)findViewById(R.id.upd_item_btn);
        view_item_btn=(Button)findViewById(R.id.view_itm_btn);
        add_itm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageItem.this,ItemAdd.class));
            }
        });
        upd_itm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageItem.this,UpdateItem.class));

            }
        });
        del_item_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageItem.this,DeleteItem.class));


            }
        });
        view_item_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageItem.this,SearchItem.class));
                                    /*Cursor res =new DatabaseHelper(ManageItem.this).getAllData();
                                    if(res.getCount() == 0) {
                                        // show message
                                        showMessage("Error","Nothing found");
                                        return;
                                    }

                                    StringBuffer buffer = new StringBuffer();
                                    while (res.moveToNext()) {
                                        buffer.append("Item Id :"+ res.getString(0)+"\n");
                                        buffer.append("Item Name :"+ res.getString(1)+"\n");
                                        buffer.append("Item Type :"+ res.getString(2)+"\n");
                                        buffer.append("Item Cuisine :"+ res.getString(3)+"\n");
                                        buffer.append("Item Category  :"+ res.getString(4)+"\n");
                                        buffer.append("Item Price :"+ res.getString(5)+"\n\n");
                                    }

                                    // Show all data
                                    showMessage("Data",buffer.toString());*/
                                }
                            }
                    );
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageItem.this,DashBoard.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(ManageItem.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
