package com.turistory.android.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * @author Cristobal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0 SNAPSHOT
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView t1,t2;
    ImageView im;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        t1= (TextView)itemView.findViewById(R.id.primary_text);
        im=(ImageView)itemView.findViewById(R.id.img_cover);
    }
}
