package com.turistory.android.activity;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.turistory.android.activity.view.adapter.AudioGuideRecyclerAdapter;
import com.turistory.android.activity.view.adapter.PlaceRecyclerAdapter;
import com.turistory.android.activity.view.adapter.RouteRecyclerAdapter;
import com.turistory.android.data.AudioGuide;
import com.turistory.android.data.AudioGuideDataProvider;
import com.turistory.android.data.Place;
import com.turistory.android.data.PlacesDataProvider;

import java.util.ArrayList;
import java.util.List;

public class AudioGuideActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    protected final static String TAG = "AudioGuideActivity";
    private RecyclerView recyclerView;
    private AudioGuideRecyclerAdapter adapter;
    private List<AudioGuide> mCountryModel = AudioGuideDataProvider.getAudioGuide();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_guide);



        adapter = new AudioGuideRecyclerAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view_audioguide);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
/*        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);*/
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.e(TAG, "Posicion -------> " +
                adapter.getItemCount());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);



        MenuItemCompat.setOnActionExpandListener(item,new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when collapsed
                adapter.setFilter(mCountryModel);
                return true; // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                return true; // Return true to expand action view
            }
        });
        return true;
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        final List<AudioGuide> filteredModelList = filter(mCountryModel, newText);
        adapter.setFilter(filteredModelList);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


    private List<AudioGuide> filter(List<AudioGuide> models, String query) {
        query = query.toLowerCase();

        final List<AudioGuide> filteredModelList = new ArrayList<>();
        for (AudioGuide model : models) {
            final String title = model.getTitle().toLowerCase();
            final String route = model.getRuta().toLowerCase();
            final String estado = model.getEstado().toLowerCase();
            if (title.contains(query) || route.contains(query) || estado.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

}
