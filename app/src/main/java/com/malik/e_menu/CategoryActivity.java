package com.malik.e_menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class CategoryActivity extends AppCompatActivity {

    ListView lv;
    Context context;

    public static int[] categoryImages={R.drawable.busine,R.drawable.tech,R.drawable.entertain,R.drawable.game,R.drawable.general,R.drawable.music,R.drawable.anim,R.drawable.sport};
    public static String[] categoryNames={"Business","Technology","Entertainment","Gaming","General","Music","Science-and-nature","Sport"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        context=this;

        lv= (ListView) findViewById(R.id.categoryList);


        lv.setAdapter(new CategoryAdaper(this, categoryNames, categoryImages));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

              try {  //Pass the image title and url to DetailsActivity
                  Intent intent = new Intent(CategoryActivity.this, GridViewActivity.class);

                  intent.putExtra("category", categoryNames[position]);


                  //Start details activity
                  startActivity(intent);

              }
              catch (Exception e){
                  Log.i("Problem", e.toString());
              }
            }
        });



    }
}
