package com.example.dsc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter <ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> e1;
    int itemresoruce;
    AboutFragment.NewsAsyncTask context;




    public ExampleAdapter(ArrayList<ExampleItem> a1) {
        e1=a1;
    }



    public ExampleAdapter(AboutFragment.NewsAsyncTask newsAsyncTask, int example_view, ArrayList<ExampleItem> exampleItems) {
      this.context=newsAsyncTask;
      this.itemresoruce=example_view;
      e1=exampleItems;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView t1;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.adobe);
        }
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.example_view,parent,false);
        ExampleViewHolder ev=new ExampleViewHolder(v);
        return ev;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentitem=e1.get(position);
        holder.t1.setText(currentitem.getT1());

    }

    @Override
    public int getItemCount() {
        return e1.size();
    }


}