package com.turistory.android.activity.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turistory.android.activity.PlaceDetailActivity;
import com.turistory.android.activity.R;
import com.turistory.android.activity.RouteActivity;
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

    private LayoutInflater inflater;
    private List<Place> places = PlacesDataProvider.getPlaces();
    private Context context;

    public RouteRecyclerAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RouteRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_route, parent, false);
        return new RouteRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RouteRecyclerViewHolder holder, int position) {
        holder.getImage().setOnClickListener(getOnClickListenerRouteDetail());
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    private View.OnClickListener getOnClickListenerRouteDetail() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RouteActivity.class);
                context.startActivity(intent);
            }
        };
    }
}
