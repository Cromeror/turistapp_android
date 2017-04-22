package com.turistory.android.testactivity.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turistory.android.testactivity.R;
import com.turistory.android.testactivity.view.holder.PreviewGalleryRecyclerViewHolder;
import com.turistory.android.data.Place;
import com.turistory.android.data.PlacesDataProvider;

import java.util.List;

/**
 * @author Cristobal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0 SNAPSHOT
 */

public class PreviewGalleryRecyclerAdapter extends RecyclerView.Adapter<PreviewGalleryRecyclerViewHolder> {

    private List<Place> places = PlacesDataProvider.getPlaces();
    //private Context context;
    private LayoutInflater inflater;

    public PreviewGalleryRecyclerAdapter(Context context) {
        //this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public PreviewGalleryRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_preview_gallery, parent, false);
        PreviewGalleryRecyclerViewHolder view = new PreviewGalleryRecyclerViewHolder(v);
        return view;
    }

    @Override
    public void onBindViewHolder(PreviewGalleryRecyclerViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
