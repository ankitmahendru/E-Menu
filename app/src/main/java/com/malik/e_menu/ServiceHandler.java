package com.malik.e_menu;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by WorkBanch on 4/11/2018.
 */

public class ServiceHandler {

    static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;
    String url;

    public ServiceHandler(String url) {
        this.url = url;
    }

    public String makeServicecall() {

	//"http://timesofindia.indiatimes.com/feeds/newsdefaultfeeds.cms?feedtype=sjson";

        System.out.println("=>URL EXecution===>" + url);

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpEntity httpentity = null;
            HttpResponse httpresponse = null;
            HttpPost httppost = new HttpPost(url);
            httpresponse = httpclient.execute(httppost);
            httpentity = httpresponse.getEntity();
            response = EntityUtils.toString(httpentity);
            System.out.println("Response call./././././././././././././././    "  + response);

            System.out.println("=>URL Response==>" + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }

}
