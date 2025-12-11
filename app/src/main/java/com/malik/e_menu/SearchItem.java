package com.malik.e_menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchItem extends AppCompatActivity{
    EditText searchid;
    Button searchitem,btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);
        searchid = (EditText) findViewById(R.id.searchid);
        searchitem = (Button) findViewById(R.id.searchitem);
        textView = (TextView) findViewById(R.id.getData111);
        textView.setText("Details Will Appear Hera!");
        textView.setMovementMethod(new ScrollingMovementMethod());
        btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getalldata(SearchItem.this,textView).execute();
            }
        });
        searchitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = searchid.getText().toString();
                new search_JSON(id, SearchItem.this,textView).execute();
            }
        });

    }

public class  getalldata extends AsyncTask<Object,Object,Object>{

    String[] itemdetails=null;
    String id;
    String status;
    Context context;
    String getId,getname,getcuisine,getcategory,gettype,getprice;
    Integer getidd,price;
    TextView textView;
    public getalldata(Context context,TextView textView) {
        this.context  = context;
        this.textView=textView;
    }
    @Override
    protected Object doInBackground(Object... objects) {
        String url = "http://10.0.3.2/resturent_service.php?act=View_data";
        Log.i("urls",url);
        ServiceHandler handler = new ServiceHandler(url);
        String response = handler.makeServicecall();

        try {
            JSONObject jsonObject=new JSONObject(response);
            status = jsonObject.getString("isFound");
            getidd=jsonObject.getInt("id");
            getname=jsonObject.getString("name");
            getcuisine=jsonObject.getString("cuisine");
            getcategory=jsonObject.getString("category");
            gettype=jsonObject.getString("type");
            price=jsonObject.getInt("price");
            if(status.equals("Yes")){
            }else{
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i("tes>>>>>>>>>>>>>>t",getname+" "+getcategory+" "+getcuisine);
        getprice=price.toString();
        getId=getidd.toString();
        itemdetails=new String[]{getId, getname, getcuisine, getcategory, gettype, getprice};
        System.out.println(itemdetails[0].toString());
        try {
            textView.setText("ID : "+itemdetails[0].toString()+"\n"+"Name : "+itemdetails[1].toString() +"\n"+
                    "Cuisine : "+itemdetails[2].toString()+"\n"+"Category : "+itemdetails[3].toString()+"\n"
                    +"Type : "+itemdetails[4].toString()+"\n"+"Price : " + itemdetails[5].toString());
        }catch (Exception e){

        }
        return null;
    }
    }
}