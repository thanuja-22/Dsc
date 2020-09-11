package com.example.dsc;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QueryUtils {



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
