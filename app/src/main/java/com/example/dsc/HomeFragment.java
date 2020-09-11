package com.example.dsc;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment {

    private TextView t1;

    HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        t1 = (TextView) getView().findViewById(R.id.site);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gothere();
            }
        });
    }

    public void gothere() {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        String query="https://www.dscsastra.com";
        intent.putExtra(SearchManager.QUERY, query);
        startActivity(intent);

    }
}