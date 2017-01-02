package com.turistory.android.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.turistory.android.activity.service.Constants;
import com.turistory.android.activity.view.adapter.PlaceRecyclerAdapter;
import com.turistory.android.data.Place;
import com.turistory.android.data.PlacesDataProvider;

import java.util.ArrayList;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static float CURRENT_ZOOM = 18f;
    private GoogleMap mMap;

    /**
     * The list of geofences used in this sample.
     */
    protected List<Geofence> mGeofenceList;

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
        mMap = googleMap;
        Integer index = getIntent().getIntExtra(PlaceRecyclerAdapter.PLACE_ID, -1) > 0 ?
                getIntent().getIntExtra(PlaceRecyclerAdapter.PLACE_ID, 0) : 0;
        Place place = PlacesDataProvider.getPlaces().get(index);

        LatLng latLng = new LatLng(place.getLatitude(), place.getLongitude());
        //googleMap.addMarker(new MarkerOptions().position(latLng).title(place.getName()));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(CURRENT_ZOOM));
    }

    /**
     * This sample hard codes geofence data. A real app might dynamically create geofences based on
     * the user's location.
     */
    public void populateGeofenceList() {
        for (Place place : PlacesDataProvider.getPlaces()) {
            mGeofenceList.add(new Geofence.Builder()
                    // Set the request ID of the geofence. This is a string to identify this
                    // geofence.
                    .setRequestId(place.getId() + "")
                    // Set the circular region of this geofence.
                    .setCircularRegion(
                            place.getLatitude(), place.getLongitude(),
                            Constants.GEOFENCE_RADIUS_IN_METERS
                    )
                    // Set the expiration duration of the geofence. This geofence gets automatically
                    // removed after this period of time.
                    .setExpirationDuration(Constants.GEOFENCE_EXPIRATION_IN_MILLISECONDS)
                    // Set the transition types of interest. Alerts are only generated for these
                    // transition. We track entry and exit transitions in this sample.
                    .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER |
                            Geofence.GEOFENCE_TRANSITION_EXIT)
                    // Create the geofence.
                    .build());
            loadSites(place);
        }
    }

    /**
     * Load place information how marker in map.
     *
     * @param entry place object
     */
    private void loadSites(Place entry) {
        LatLng position = new LatLng(entry.getLatitude(), entry.getLongitude());
        mMap.addMarker(new MarkerOptions().position(position).title(entry.getName()));
    }
}