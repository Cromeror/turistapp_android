package com.turistory.android.testactivity.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.turistory.android.testactivity.MapActivity;
import com.turistory.android.testactivity.R;
import com.turistory.android.testactivity.view.adapter.AudioGuideRecyclerAdapter;
import com.turistory.android.data.AudioGuide;
import com.turistory.android.data.AudioGuideDataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AudioGuideFragment extends Fragment implements SearchView.OnQueryTextListener {
    protected final static String TAG = "AudioGuideActivity";
    private RecyclerView recyclerView;
    private AudioGuideRecyclerAdapter adapter;
    private List<AudioGuide> mCountryModel = AudioGuideDataProvider.getAudioGuide();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public AudioGuideFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_audio_guide, container, false);

        adapter = new AudioGuideRecyclerAdapter(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view_audioguide);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
/*        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);*/
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.e(TAG, "Posicion -------> " +
                adapter.getItemCount());
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);


        MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {
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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.map_item2:
                Intent intentMap = new Intent(getActivity(), MapActivity.class);
                startActivity(intentMap);
                break;
        }
        return super.onOptionsItemSelected(item);
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
            final String estado = model.obtenerEstado().toLowerCase();
            if (title.contains(query) || route.contains(query) || estado.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

}
