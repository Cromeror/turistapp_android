package com.turistory.android.testactivity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turistory.android.testactivity.R;
import com.turistory.android.testactivity.view.adapter.PlaceRecyclerAdapter;
import com.turistory.android.data.Place;
import com.turistory.android.data.PlacesDataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment
        implements SearchView.OnQueryTextListener {
    private PlaceRecyclerAdapter adapter;
    private List<Place> mCountryModel = PlacesDataProvider.getPlaces();
    protected final static String TAG = "PlacesActivity";

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_places, container, false);

        adapter = new PlaceRecyclerAdapter(getActivity());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view_places);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Log.e(TAG, "Posicion -------> " + adapter.getItemCount());

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<Place> filteredModelList = filter(mCountryModel, newText);
        adapter.setFilter(filteredModelList);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<Place> filter(List<Place> models, String query) {
        query = query.toLowerCase();

        final List<Place> filteredModelList = new ArrayList<>();
        for (Place model : models) {
            final String text = model.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
