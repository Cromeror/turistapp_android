package com.turistory.android.activity.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.turistory.android.activity.R;

/**
 * @author Cristobal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0 SNAPSHOT
 */

public class RouteRecyclerViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;

    public RouteRecyclerViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.img_cover);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
