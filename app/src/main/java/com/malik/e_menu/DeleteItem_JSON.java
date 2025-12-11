package com.malik.e_menu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.malik.e_menu.ServiceHandler;

import org.json.JSONException;
import org.json.JSONObject;

public class DeleteItem_JSON extends AsyncTask<Object,Object,Object> {
    String id;
    String status;
    Context context;
    public DeleteItem_JSON(String id,Context context) {
        this.id = id;
        this.context  = context;
    }
    @Override
    protected Object doInBackground(Object... objects) {
        String url = "http://"+UserSelection.urlget+"/resturent_service.php?act=Delete_Items&Request_id="+id;
        Log.i("urls",url);
        ServiceHandler handler = new ServiceHandler(url);
        String response = handler.makeServicecall();
        try {
            JSONObject jsonObject=new JSONObject(response);
            status = jsonObject.getString("isDeleted");
            if(status.equals("Yes")){
            }else{
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
