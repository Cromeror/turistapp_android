package com.turistory.android.testactivity.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.turistory.android.testactivity.AudioPlayerActivity;
import com.turistory.android.testactivity.R;
import com.turistory.android.testactivity.view.holder.AudioGuideRecyclerViewHolder;
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
    protected final static String ARG_PLACE_ID = "PLACE_ID";
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


        if(audioguides.get(position).getEstado() == 0){
            holder.getEstado().setBackgroundColor(0xff1b5e20);
        }else {
            holder.getEstado().setBackgroundColor(0xffb71c1c);
        }
        holder.getTitle().setText(audioguides.get(position).getTitle());
        holder.getRuta().setText(audioguides.get(position).getRuta());
        holder.getEstado().setText(audioguides.get(position).obtenerEstado());
        holder.getCover().setImageResource(audioguides.get(position).getPortada());
        holder.getCover().setOnClickListener(getOnClickListenerAudioPlayer(position));
    }

    private View.OnClickListener getOnClickListenerAudioPlayer(final Integer position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 //#4caf50

                if(audioguides.get(position).obtenerEstado().equalsIgnoreCase("GRATIS")){
                    if (position != null) {
                        Intent intent = new Intent(context, AudioPlayerActivity.class);
                        int id= audioguides.get(position).getId();
                        Toast toast = Toast.makeText(context,"Utilice auriculares para un mejor sonido", Toast.LENGTH_SHORT);
                        toast.show();
                        intent.putExtra(AudioPlayerActivity.ARG_PLACE_ID, id);
                        context.startActivity(intent);
                        Activity activity = (Activity) context;
                        activity.overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                    }
                }else {
                    Toast toast1 =
                            Toast.makeText(context,"Bloqueado", Toast.LENGTH_SHORT);
                    toast1.show();

                }



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
