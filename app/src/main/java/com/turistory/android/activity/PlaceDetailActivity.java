package com.turistory.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaquimley.faboptions.FabOptions;
import com.mzelzoghbi.zgallery.ZGrid;
import com.mzelzoghbi.zgallery.entities.ZColor;
import com.turistory.android.activity.view.adapter.PlaceRecyclerAdapter;
import com.turistory.android.activity.view.adapter.PreviewGalleryRecyclerAdapter;
import com.turistory.android.data.Place;
import com.turistory.android.data.PlacesDataProvider;

import java.util.ArrayList;

public class PlaceDetailActivity extends AppCompatActivity
        implements View.OnClickListener {
    public final static String ARG_INDEX = "com.crom.miguiapp.PlaceDetailActivity.index";
    private Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PreviewGalleryRecyclerAdapter adapter = new PreviewGalleryRecyclerAdapter(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.previewGalleryRecyclerView);
        recyclerView.setAdapter(adapter);
        ImageButton btnMore = (ImageButton) findViewById(R.id.btn_more);
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> imagenes = new ArrayList<String>();
                imagenes.add("http://destinocartagena.co/sites/default/files/styles/large/public/field/image/MURALLAS%20CARTAGENA%20DE%20INDIAS-CORPORACION%20TURISMO%20DE%20CARTAGENA-flikr.jpg?itok=5NrvR3rI");
                ZGrid.with(PlaceDetailActivity.this, imagenes)
                        .setToolbarColorResId(R.color.primary) // toolbar color
                        .setTitle("Zak Gallery") // toolbar title
                        .setToolbarTitleColor(ZColor.WHITE) // toolbar title color
                        .setSpanCount(3) // colums count
                        .setGridImgPlaceHolder(R.color.primary) // color placeholder for the grid image until it loads
                        .show();
            }
        });

        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(PlaceDetailActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        FabOptions fabOptions = (FabOptions) findViewById(R.id.fab_options);
        fabOptions.setButtonsMenu(R.menu.floating_place_menu);
        fabOptions.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getIntent().getIntExtra(PlaceRecyclerAdapter.PLACE_ID, 0) >= 0) {
            loadDetail(getIntent().getIntExtra(PlaceRecyclerAdapter.PLACE_ID, 0));
        }
    }

 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }*/

/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.map_item:
                Intent intent = new Intent(this, MapActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }*/

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
        Intent intent = new Intent(PlaceDetailActivity.this, MapActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.faboptions_map:
                Intent intent = new Intent(this, MapActivity.class);
                startActivity(intent);
                break;
            case R.id.faboptions_audio:
                break;
            default:
                // no-op
        }
    }
}