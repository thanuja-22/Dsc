package com.example.dsc;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;

import java.util.ArrayList;


public class AboutFragment extends Fragment {

    private RecyclerView mrecyclerview;
    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager mlayoutManager;
    public static final String JSON_STRING="https://wayhike.com/dsc/demo_app_api.php";

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_about, container, false);

        ArrayList<ExampleItem> a1= null;
        try {
            a1 = com.example.dsc.QueryUtils.extractFeaturesFromJson(JSON_STRING);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mrecyclerview=(RecyclerView)rootView.findViewById(R.id.recycler_view);
        mrecyclerview.setHasFixedSize(true);
        mlayoutManager=new LinearLayoutManager(getContext());
        madapter=new ExampleAdapter(a1);
        mrecyclerview.setLayoutManager(mlayoutManager);
        mrecyclerview.setAdapter(madapter);
        NewsAsyncTask n1=new NewsAsyncTask();
        n1.execute(JSON_STRING);


        return rootView;
    }
    class NewsAsyncTask extends AsyncTask<String,Void,ArrayList<ExampleItem>>{

        @Override
        protected ArrayList<ExampleItem> doInBackground(String... strings) {
            ArrayList<ExampleItem> a1=new ArrayList<>();
            try {
                a1=QueryUtils.fetchNews(JSON_STRING);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.e("AboutFragment","msg"+a1);
            return a1;
        }

        @Override
        protected void onPostExecute(ArrayList<ExampleItem> exampleItems) {
            madapter = new ExampleAdapter(this, R.layout.example_view, exampleItems);
            mrecyclerview.setAdapter(madapter);
            super.onPostExecute(exampleItems);
        }
    }

}