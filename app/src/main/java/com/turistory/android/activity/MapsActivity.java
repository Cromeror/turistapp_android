package com.turistory.android.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.turistory.android.activity.view.adapter.RecyclerAdapterPlace;
import com.turistory.android.data.Place;
import com.turistory.android.data.PlacesDataProvider;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static float CURRENT_ZOOM = 18f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Integer index = getIntent().getIntExtra(RecyclerAdapterPlace.PLACE_ID, -1) > 0 ?
                getIntent().getIntExtra(RecyclerAdapterPlace.PLACE_ID, 0) : 0;
        Place place = PlacesDataProvider.getPlaces().get(index);

        LatLng latLng = new LatLng(place.getLatitude(), place.getLongitude());
        googleMap.addMarker(new MarkerOptions().position(latLng).title(place.getName()));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(CURRENT_ZOOM));
    }
}