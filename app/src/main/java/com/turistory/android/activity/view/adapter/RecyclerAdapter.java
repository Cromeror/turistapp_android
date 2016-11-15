package com.turistory.android.activity.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turistory.android.activity.MapsActivity;
import com.turistory.android.activity.view.holder.RecyclerViewHolder;
import com.turistory.android.activity.R;


/**
 * Created by Next University
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    String[] arreglo = {"Layouts", "Fragment", "Items", "Java", "Android"};
    Context context;
    LayoutInflater inflater;

    public RecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item, parent, false);
        RecyclerViewHolder view1 = new RecyclerViewHolder(v);
        return view1;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.getTitle().setText(arreglo[position]);
        holder.getCoverImage().setOnClickListener(onClickListener);
        holder.getCoverImage().setTag(holder);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewHolder vh = (RecyclerViewHolder) v.getTag();
            //int posicion = vh.getAdapterPosition();
            Intent intent = new Intent(context, MapsActivity.class);
            context.startActivity(intent);
        }
    };

    @Override
    public int getItemCount() {
        return arreglo.length;
    }
}
