package com.malik.e_menu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuTab_JSON extends AsyncTask<Object,Object,Object> {
    static  Context context;
    ArrayList<String> getId,getname,getprice;
    Integer getidd,price;
    ListView listView;
    String category;
    public MenuTab_JSON(String category,Context context) {
        this.context  = context;
        this.category=category;
    }



    @Override
    protected Object[] doInBackground(Object... objects) {
        String url = "http://"+UserSelection.urlget+"/resturent_servicetest.php?act=Data_Selection&Request_category="+category;
        Log.i("urls",url);
        ServiceHandler handler = new ServiceHandler(url);
        String response = handler.makeServicecall();

        try {
            // JSONObject jsonObject=new JSONObject(response);
            JSONArray status = new JSONArray(response);
            for(int i=0;i<status.length();i++)
            {
                JSONObject json=status.getJSONObject(i);
                getidd=json.getInt("id");
                getname.add(json.getString("name"));
                price=json.getInt("price");
                getprice.add(price.toString());
                getId.add(getidd.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onPostExecute(context);
        return null;

    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
