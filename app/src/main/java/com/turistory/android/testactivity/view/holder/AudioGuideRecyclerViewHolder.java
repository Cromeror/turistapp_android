package com.turistory.android.testactivity.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.turistory.android.testactivity.R;

/**
 * Created by Ivan on 21/02/2017.
 */

public class AudioGuideRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView ruta;
    private TextView estado;
    private ImageView cover;
    private ImageView btn;

    public AudioGuideRecyclerViewHolder(View itemView) {
        super(itemView);
        cover = (ImageView) itemView.findViewById(R.id.item_audioguide_list_img_cover);
        title = (TextView) itemView.findViewById(R.id.text_title_audioguide);
        ruta = (TextView) itemView.findViewById(R.id.text_subtitle_audioguide);
        estado = (TextView) itemView.findViewById(R.id.estado);


    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getRuta() {
        return ruta;
    }

    public void setRuta(TextView ruta) {
        this.ruta = ruta;
    }

    public TextView getEstado() {
        return estado;
    }

    public void setEstado(TextView estado) {
        this.estado = estado;
    }

    public ImageView getCover() {
        return cover;
    }

    public void setCover(ImageView cover) {
        this.cover = cover;
    }

    public ImageView getBtn() {
        return btn;
    }

    public void setBtn(ImageView btn) {
        this.btn = btn;
    }
}
