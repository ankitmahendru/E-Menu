package com.malik.e_menu;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NewsScreen extends AppCompatActivity {
String News_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_screen);
        News_url="https://newsapi.org/v2/top-headlines?country=in&apiKey=58444f2296514ccd9893956978e7a10b";
        new NewsScreen.AsyncHttptask().execute(News_url);
    }
public class AsyncHttptask extends AsyncTask<String, Void,String>{
    @Override
    protected String doInBackground(String... urls) {
        String result="";
        URL url;
        HttpURLConnection urlConnection=null;
        try {
            url=new URL(urls[0]);
            urlConnection=(HttpURLConnection)url.openConnection();
            String response=streamToString(urlConnection.getInputStream());
            parseResult(response);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
private void parseResult(String result){
    JSONObject response= null;
    try {
        response = new JSONObject(result);
        JSONArray articles=response.optJSONArray("articles");

        for(int i=0;i<articles.length();i++){
            JSONObject article=articles.optJSONObject(i);
            String title=article.optString("title");
            Log.i("Titles",title);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
String streamToString(InputStream stream) throws IOException{
    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(stream));
    String data;
    String result="";

    while ((data = bufferedReader.readLine())!=null){
    result+=data;
    }
    if (null!=stream){
    stream.close();
    }
    return result;
    }

}
