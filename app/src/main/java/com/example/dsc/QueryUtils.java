package com.example.dsc;

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
import java.nio.charset.Charset;
import java.util.ArrayList;

public class QueryUtils {



    public static ArrayList<ExampleItem> fetchNews(String s) throws JSONException {
        String jsonresponse="";
        URL url=createurl(s);
        try{
            jsonresponse=makeHttpRequest(url);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //Log.e("QueryUtils","fetchnews");
        ArrayList<ExampleItem> w =extractFeaturesFromJson(jsonresponse);
        return w;
    }
    public static URL createurl(String s){
        URL u=null;
        try{
            u=new URL(s);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return u;
    }
    public static String makeHttpRequest(URL url) throws IOException{
        String jsonrespone="";
        HttpURLConnection urlConnection;
        try {
            urlConnection=(HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if(urlConnection.getResponseCode()==200){
                InputStream inputStream=urlConnection.getInputStream();
                jsonrespone=readFromStream(inputStream);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return jsonrespone;
    }
    public static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder es=new StringBuilder();
        //Log.e("QueryUtils","readFromStream");
        if(inputStream!=null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bf = new BufferedReader(inputStreamReader);
            String s = bf.readLine();
            while (s != null) {
                es.append(s);
                s = bf.readLine();
            }
        }
        return es.toString();
    }
    public static ArrayList<ExampleItem> extractFeaturesFromJson(String jsonresponse) throws JSONException {
        ArrayList<ExampleItem> wu=new ArrayList<ExampleItem>();
        ExampleItem ex=null;
        try {

            JSONObject jo=new JSONObject(jsonresponse);
            JSONArray a1=jo.getJSONArray("event_titles");
            for(int k=5;k<a1.length();k++){

                Log.e("QueryUtils","k"+a1.getString(k));
                ex=new ExampleItem(a1.getString(k));
                wu.add(ex);
            }
            Log.e("QueryUtils","msg"+ex);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return wu;
    }
}
