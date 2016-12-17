package com.turistory.android.activity.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.turistory.android.activity.MapsActivity;
import com.turistory.android.activity.PlaceDetailActivity;
import com.turistory.android.activity.view.holder.RecyclerViewHolderPlace;
import com.turistory.android.activity.R;
import com.turistory.android.data.Place;
import com.turistory.android.data.PlacesDataProvider;

import java.util.List;

/**
 * @author Cristobal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0 SNAPSHOT
 */
public class RecyclerAdapterPlace extends RecyclerView.Adapter<RecyclerViewHolderPlace> {
    public final static String PLACE_ID = RecyclerAdapterPlace.class.getPackage() + ".place.id";

    private List<Place> places = PlacesDataProvider.getPlaces();
    private Context context;
    private LayoutInflater inflater;

    public RecyclerAdapterPlace(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolderPlace onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item, parent, false);
        RecyclerViewHolderPlace view = new RecyclerViewHolderPlace(v);
        return view;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderPlace holder, int position) {
        Place place = places.get(position);
        //holder.getTitle().setText(place.getName());
        holder.getBtnMore().setOnClickListener(getOnClickListenerPlaceDetail(position));
        /*holder.getCoverImage().setOnClickListener(getOnClickListenerPlaceDetail(position));
        holder.getBtnExplore().setOnClickListener(getOnClickListenerExplore(position));
        holder.getCoverImage().setTag(holder);*/
    }

    private OnClickListener getOnClickListenerExplore(final Integer id) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RecyclerViewHolderPlace vh = (RecyclerViewHolderPlace) v.getTag();
                //int posicion = vh.getAdapterPosition();
                Intent intent = new Intent(context, MapsActivity.class);
                if (id != null) {
                    intent.putExtra(PLACE_ID, id);
                }
                context.startActivity(intent);
            }
        };
    }

    private OnClickListener getOnClickListenerPlaceDetail(final Integer id) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RecyclerViewHolderPlace vh = (RecyclerViewHolderPlace) v.getTag();
                //int posicion = vh.getAdapterPosition();
                Intent intent = new Intent(context, PlaceDetailActivity.class);
                if (id != null) {
                    intent.putExtra(PLACE_ID, id);
                }
                context.startActivity(intent);
            }
        };
    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
