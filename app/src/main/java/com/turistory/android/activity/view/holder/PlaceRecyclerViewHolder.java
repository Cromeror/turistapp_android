package com.turistory.android.activity.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.turistory.android.activity.R;


/**
 * @author Cristobal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0 SNAPSHOT
 */
public class PlaceRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private ImageView coverImage;
    private ImageView btnShare;
    private ImageView btnExplore;
    private ImageView btnThumbUp;
    private ImageView btnMore;

    public PlaceRecyclerViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.primary_text);
        coverImage = (ImageView) itemView.findViewById(R.id.item_route_img_cover);
        btnExplore = (ImageView) itemView.findViewById(R.id.btn_explore);
        btnShare = (ImageView) itemView.findViewById(R.id.btn_share);
        btnThumbUp = (ImageView) itemView.findViewById(R.id.btn_thumb_up);
        btnMore = (ImageView) itemView.findViewById(R.id.btn_more);

    }

    public ImageView getBtnMore() {
        return btnMore;
    }

    public void setBtnMore(ImageView btnMore) {
        this.btnMore = btnMore;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public ImageView getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(ImageView coverImage) {
        this.coverImage = coverImage;
    }

    public ImageView getBtnShare() {
        return btnShare;
    }

    public void setBtnShare(ImageView btnShare) {
        this.btnShare = btnShare;
    }

    public ImageView getBtnExplore() {
        return btnExplore;
    }

    public void setBtnExplore(ImageView btnExplore) {
        this.btnExplore = btnExplore;
    }

    public ImageView getBtnThumbUp() {
        return btnThumbUp;
    }

    public void setBtnThumbUp(ImageView btnThumbUp) {
        this.btnThumbUp = btnThumbUp;
    }
}
