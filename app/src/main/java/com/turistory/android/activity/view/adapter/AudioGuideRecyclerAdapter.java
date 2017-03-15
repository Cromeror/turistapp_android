package com.turistory.android.activity.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turistory.android.activity.AudioPlayerActivity;
import com.turistory.android.activity.R;
import com.turistory.android.activity.view.holder.AudioGuideRecyclerViewHolder;
import com.turistory.android.data.AudioGuide;
import com.turistory.android.data.AudioGuideDataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 21/02/2017.
 */

public class AudioGuideRecyclerAdapter extends RecyclerView.Adapter<AudioGuideRecyclerViewHolder> {
    // public final static String AUDIOGUIDE_ID = AudioGuideRecyclerAdapter.class.getPackage() + ".audioguides.id";


    private LayoutInflater inflater;
    private List<AudioGuide> audioguides = AudioGuideDataProvider.getAudioGuide();
    private Context context;


    public AudioGuideRecyclerAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public AudioGuideRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_audioguide, parent, false);
        return new AudioGuideRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AudioGuideRecyclerViewHolder holder, int position) {


        holder.getTitle().setText(audioguides.get(position).getTitle());
        holder.getSubtitle().setText(audioguides.get(position).getSubtitle());
        holder.getCover().setImageResource(audioguides.get(position).getCover());
        holder.getCover().setOnClickListener(getOnClickListenerAudioPlayer(position));
    }

    private View.OnClickListener getOnClickListenerAudioPlayer(final Integer position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AudioPlayerActivity.class);

                int id= audioguides.get(position).getId();


                if (position != null) {
                    intent.putExtra("posicion", id);
                }
                context.startActivity(intent);
            }
        };
    }

    @Override
    public int getItemCount() {
        return audioguides.size();
    }

    public void setFilter(List<AudioGuide> nuevaLista){
        audioguides = new ArrayList<>();
        audioguides.addAll(nuevaLista);
        notifyDataSetChanged();
    }


}
