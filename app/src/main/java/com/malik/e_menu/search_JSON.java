package com.malik.e_menu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.malik.e_menu.ServiceHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class search_JSON extends AsyncTask<Object,Object,Object> {
    String[] itemdetails=null;
    String id;
    String status;
    Context context;
    String getId,getname,getcuisine,getcategory,gettype,getprice;
    Integer getidd,price;
    TextView textView;
    public search_JSON(String id,Context context,TextView textView) {
        this.id = id;
        this.context  = context;
        this.textView=textView;
    }



    @Override
    protected Object doInBackground(Object... objects) {
        String url = "http://"+UserSelection.urlget+"/resturent_servicetest.php?act=Data_Selection&Request_category=starters";
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
            getname=json.getString("name");
            getcuisine=json.getString("cuisine");
            getcategory=json.getString("category");
            gettype=json.getString("type");
            price=json.getInt("price");
                Log.i("tes>>>>>>>>>>>>>>t",getname+" "+getcategory+" "+getcuisine);
                getprice=price.toString();
                getId=getidd.toString();
                itemdetails=new String[]{getId, getname, getcuisine, getcategory, gettype, getprice};
                System.out.println(itemdetails[0].toString()+itemdetails[1].toString());
                String settexrstr=textView.getText().toString()+"ID : "+itemdetails[0].toString()+"\n"+"Name : "+itemdetails[1].toString() +"\n"+
                        "Cuisine : "+itemdetails[2].toString()+"\n"+"Category : "+itemdetails[3].toString()+"\n"
                        +"Type : "+itemdetails[4].toString()+"\n"+"Price : " + itemdetails[5].toString();
                textView.setText(settexrstr);
            }
            if(status.equals("Yes")){
            }else{
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            String settexrstr="ID : "+itemdetails[0].toString()+"\n"+"Name : "+itemdetails[1].toString() +"\n"+
                    "Cuisine : "+itemdetails[2].toString()+"\n"+"Category : "+itemdetails[3].toString()+"\n"
                    +"Type : "+itemdetails[4].toString()+"\n"+"Price : " + itemdetails[5].toString();
            textView.setText(settexrstr);
        }catch (Exception e){
            System.out.print(e.getMessage().toString().toUpperCase());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
