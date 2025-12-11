package com.malik.e_menu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;


public class ItemAdd_Json extends AsyncTask<Object,Object,Object> {

    String id,name,cuisine,category,type,price;
    String status;
    Context context;

    public ItemAdd_Json(String id, String name, String cuisine, String category, String type, String price, Context context) {
        this.name = name.replaceAll(" ","%20");
        this.id = id;
        this.cuisine = cuisine;
        this.category = category;
        this.type = type;
        this.price = price;
        this.context  = context;

    }

    @Override
    protected Object doInBackground(Object... objects) {
        SharedPreferences preferences=context.getSharedPreferences("mydata",Context.MODE_PRIVATE);
        String urlmain =preferences.getString("urlmain",null);
        String url = "http://"+urlmain+"resturent_service.php?act=Insert_Items&Request_id="+id+"&Request_name="+name+"&Request_cuisine="+cuisine+"&Request_category="+category+"&Request_type="+type+"&Request_price="+price;
        Log.i("urls",url);
        ServiceHandler handler = new ServiceHandler(url);
        String response = handler.makeServicecall();
        try {
            JSONObject jsonObject=new JSONObject(response);
            status = jsonObject.getString("AccountCreated");
            if(status.equals("DatasubmittedSuccessfully")){
            }else{
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPostExecute(Object o) {
    }
}
