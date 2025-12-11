package com.malik.e_menu;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class Tab2 extends Fragment {


    ListView listView;
    String category;
    Context context;

    public Tab2() {
    }

    @SuppressLint("ValidFragment")
    public Tab2(Context context) {
        this.context=context;
        category="starters";
        //Required empty public constructor
    }
    class myAsynTask extends AsyncTask<Object,Object,Object>{

        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> price = new ArrayList<>();
        ArrayList<ImageButton> btn = new ArrayList<>();
        ArrayList<ImageButton> btn1 = new ArrayList<>();
        ArrayList<EditText> Ed = new ArrayList<>();
        String getId,getname,getprice;
        Integer getidd,price1;

        Context context;
        ListView listView;

        myAsynTask(Context context, ListView listView){

            this.context = context;
            this.listView = listView;
        }

        @Override
        protected Object doInBackground(Object... objects) {

            String url = "http://"+UserSelection.urlget+"/resturent_servicetest.php?act=Data_Selection&Request_category=main%20course";
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
                    getname=(json.getString("name"));
                    price1=json.getInt("price");
                    getprice=(price1.toString());
                    getId=(getidd.toString());
                    name.add(getname.toString());
                    price.add(getprice);
                    System.out.println(name+"       "+price);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            AdapterClass adapter = new AdapterClass(name, price,btn ,btn1,Ed, context);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_tab2, container, false);
        listView = (ListView) v.findViewById(R.id.list2);

        new Tab2.myAsynTask(context,listView).execute();



        return v;

    }
}