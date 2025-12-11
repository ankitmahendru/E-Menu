package com.malik.e_menu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdateItem_JSON extends AsyncTask<Object,Object,Object> {
    String id,name,cuisine,category,type,price;
    String status;
    Context context;
    public UpdateItem_JSON(String id, String name, String cuisine, String category, String type, String price, Context context) {
        this.name = name;
        this.id = id;
        this.cuisine = cuisine;
        this.category = category;
        this.type = type;
        this.price = price;
        this.context  = context;
    }
    @Override
    protected Object doInBackground(Object... objects) {
        String url = "http://"+UserSelection.urlget+"/resturent_service.php?act=Update_Item&Request_id="+id+"&Request_name="+name+"&Request_cuisine="+cuisine+"&Request_category="+category+"&Request_type="+type+"&Request_price="+price;
        Log.i("urls",url);
        ServiceHandler handler = new ServiceHandler(url);
        String response = handler.makeServicecall();
        try {
            JSONObject jsonObject=new JSONObject(response);
            status = jsonObject.getString("isDataUpdated");
            if(status.equals("YES")){
            }else{
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
