package com.turistory.android.activity.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turistory.android.activity.R;
import com.turistory.android.activity.view.holder.RecyclerViewHolder;
import com.turistory.android.activity.view.holder.RouteRecyclerViewHolder;
import com.turistory.android.data.Place;
import com.turistory.android.data.PlacesDataProvider;

import java.util.List;

/**
 * @author Cristobal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0 SNAPSHOT
 */
public class RouteRecyclerAdapter extends RecyclerView.Adapter<RouteRecyclerViewHolder> {

    LayoutInflater inflater;
    List<Place> places = PlacesDataProvider.getPlaces();

    public RouteRecyclerAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RouteRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_route, parent, false);
        RouteRecyclerViewHolder viewHolder = new RouteRecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RouteRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
