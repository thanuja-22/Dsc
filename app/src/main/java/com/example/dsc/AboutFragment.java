package com.example.dsc;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;

import java.util.ArrayList;


public class AboutFragment extends Fragment {

    private RecyclerView mrecyclerview;
    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager mlayoutManager;
    public static final String JSON_STRING="{\"event_titles\":[\"Adobe XD Scratchclass - Introduction\",\"Latest Innovation and Trends in Flutter\",\"Discuss with DSC - Blockchain and Pi cryptocurrency\",\"Discuss with DSC - Data Engineering with Spark using Databricks\",\"Free Practical Cloud course\",\"DeveLup Series - Machine Learning Novice to Jarvis\",\"DeveLup Series - Problem Solving with Design Thinking\",\"DeveLup Series - Touring google Cloud\",\"DeveLup Series - Unboxing Mixed Reality\",\"DeveLup Series - Flutter Zero to Hero\",\"DeveLup Series - Kickstart with Firebase\",\"DeveLup Series - Graphic Designing - Intermediate\",\"DeveLup Series - Introduction to JavaScript\",\"DeveLup Series - Getting started with LaTeX\",\"DeveLup Series Launch\"]}";

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
            a1 = com.example.dscsastra.QueryUtils.extractFeaturesFromJson(JSON_STRING);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mrecyclerview=(RecyclerView)rootView.findViewById(R.id.recycler_view);
        mrecyclerview.setHasFixedSize(true);
        mlayoutManager=new LinearLayoutManager(getContext());
        madapter=new ExampleAdapter(a1);
        mrecyclerview.setLayoutManager(mlayoutManager);
        mrecyclerview.setAdapter(madapter);


        return rootView;
    }

}