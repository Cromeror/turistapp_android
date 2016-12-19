package com.turistory.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jean.jcplayer.JcAudio;
import com.example.jean.jcplayer.JcPlayerView;
import com.turistory.android.activity.view.adapter.PlaceRecyclerAdapter;
import com.turistory.android.activity.view.adapter.PreviewGalleryRecyclerAdapter;
import com.turistory.android.data.Place;
import com.turistory.android.data.PlacesDataProvider;

import java.util.ArrayList;

public class PlaceDetailActivity extends AppCompatActivity {
    public final static String ARG_INDEX = "com.crom.miguiapp.PlaceDetailActivity.index";
    private Place place;
    private JcPlayerView jcplayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        PreviewGalleryRecyclerAdapter adapter = new PreviewGalleryRecyclerAdapter(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.previewGalleryRecyclerView);
        recyclerView.setAdapter(adapter);

        jcplayerView = (JcPlayerView) findViewById(R.id.jcplayer);

        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(PlaceDetailActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromRaw("Raw audio", R.raw.audio_tower_clock));
        jcplayerView.initPlaylist(jcAudios);
        jcplayerView.createNotification(); // default icon
        if (getIntent().getIntExtra(PlaceRecyclerAdapter.PLACE_ID, 0) >= 0) {
            loadDetail(getIntent().getIntExtra(PlaceRecyclerAdapter.PLACE_ID, 0));
        }
    }

    private void loadDetail(int intExtra) {
        this.place = PlacesDataProvider.getPlaces().get(intExtra);
        TextView title = (TextView) findViewById(R.id.title_place_detail);
        TextView description = (TextView) findViewById(R.id.description_place_detail);
        ImageView imagen = (ImageView) findViewById(R.id.image_toolbars);

        title.setText(place.getName());
        description.setText(place.getDescription());
        if (place.getCover() != null)
            imagen.setImageResource(place.getCover());
    }

    public void playAction(View view) {
        /*if (place.getAudioResource() != null) {
            ControllerMediaPlayerService.getInstance().initService(this, place.getAudioResource());
        }*/
    }

    public void goMapAction(View view) {
        Intent intent = new Intent(PlaceDetailActivity.this, MapsActivity.class);
        startActivity(intent);
    }
}
