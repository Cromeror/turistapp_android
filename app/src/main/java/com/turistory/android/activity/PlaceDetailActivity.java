package com.turistory.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.turistory.android.activity.view.adapter.PlaceRecyclerAdapter;
import com.turistory.android.data.Place;
import com.turistory.android.data.PlacesDataProvider;

public class PlaceDetailActivity extends AppCompatActivity {
    public final static String ARG_INDEX = "com.crom.miguiapp.PlaceDetailActivity.index";
    private Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getIntent().getIntExtra(PlaceRecyclerAdapter.PLACE_ID, 0) >= 0) {
            loadDetail(getIntent().getIntExtra(PlaceRecyclerAdapter.PLACE_ID, 0));
        }
    }

    private void loadDetail(int intExtra) {
        this.place = PlacesDataProvider.getPlaces().get(intExtra);
        TextView title = (TextView) findViewById(R.id.title_place_detail);
        TextView description = (TextView) findViewById(R.id.description_place_detail);
        //ImageView imagen = (ImageView) findViewById(R.id.image_toolbars);

        title.setText(place.getName());
        description.setText(place.getDescription());
        //imagen.setImageResource(R.mipmap.tower_clock);
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
