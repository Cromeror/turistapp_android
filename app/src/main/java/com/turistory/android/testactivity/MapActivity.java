package com.turistory.android.testactivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.turistory.android.testactivity.service.Constants;
import com.turistory.android.testactivity.service.GeofenceTransitionsIntentService;
import com.turistory.android.testactivity.view.custom.CustomMarker;
import com.turistory.android.testactivity.view.custom.data.MarkerPlaceData;
import com.turistory.android.communication.ComunicationHelper;
import com.turistory.android.communication.DistanceMatrixHelperJson;
import com.turistory.android.communication.dto.distance_matrix.DistanceMatrix;
import com.turistory.android.data.AudioGuide;
import com.turistory.android.data.AudioGuideDataProvider;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristóbal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0
 */

public class MapActivity extends FragmentActivity
        implements OnMapReadyCallback, ConnectionCallbacks, OnConnectionFailedListener,
        ResultCallback<Status>, GoogleMap.OnMarkerClickListener {

    protected final static String TAG = "MainActivity";
    protected final static String ARG_PLACE_ID = "PLACE_ID";

    /**
     * The list of geofences used in this sample.
     */
    protected List<Geofence> mGeofenceList;
    /**
     * Used when requesting to add or remove geofences.
     */
    private PendingIntent mGeofencePendingIntent;

    private GoogleMap map;
    private GoogleApiClient mGoogleApiClient;
    private float currentZoom = 18.0f;
    private Location mLastLocation;
    private LatLng focusIn;

    protected synchronized void buildGoogleApiClient() {
        Toast.makeText(this, "buildGoogleApiClient", Toast.LENGTH_SHORT).show();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    private void ubicationCamera(LatLng position) {
        map.moveCamera(CameraUpdateFactory.newLatLng(position));
        map.animateCamera(CameraUpdateFactory.zoomTo(currentZoom));
    }

    public void setUpMap() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        CustomMarker custom = new CustomMarker(MapActivity.this);
        map.setInfoWindowAdapter(custom);
        map.setOnInfoWindowClickListener(custom);
        map.setOnMarkerClickListener(this);
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.setMyLocationEnabled(true);
    }

    /**
     * This sample hard codes geofence data. A real app might dynamically create geofences based on
     * the user's location.
     */
    public void populateGeofenceList() {
        for (AudioGuide audioGuide : AudioGuideDataProvider.getAudioGuide()) {
            mGeofenceList.add(new Geofence.Builder()
                    // Set the request ID of the geofence. This is a string to identify this
                    // geofence.
                    .setRequestId(audioGuide.getId() + "")
                    // Set the circular region of this geofence.
                    .setCircularRegion(
                            audioGuide.getLatitude(),
                            audioGuide.getLongitude(),
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
            loadSites(audioGuide);
        }
    }


    /**
     * Builds and returns a GeofencingRequest. Specifies the list of geofences to be monitored.
     * Also specifies how the geofence notifications are initially triggered.
     */
    private GeofencingRequest getGeofencingRequest() {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        // The INITIAL_TRIGGER_ENTER flag indicates that geofencing service should trigger a
        // GEOFENCE_TRANSITION_ENTER notification when the geofence is added and if the device
        // is already inside that geofence.
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);
        // Add the geofences to be monitored by geofencing service.
        builder.addGeofences(mGeofenceList);
        // Return a GeofencingRequest.
        return builder.build();
    }

    /**
     * Gets a PendingIntent to send with the request to add or remove Geofences. Location Services
     * issues the Intent inside this PendingIntent whenever a geofence transition occurs for the
     * current list of geofences.
     *
     * @return A PendingIntent for the IntentService that handles geofence transitions.
     */
    private PendingIntent getGeofencePendingIntent() {
        // Reuse the PendingIntent if we already have it.
        if (mGeofencePendingIntent != null) {
            return mGeofencePendingIntent;
        }
        Intent intent = new Intent(this, GeofenceTransitionsIntentService.class);
        // We use FLAG_UPDATE_CURRENT so that we get the same pending intent back when calling
        // addGeofences() and removeGeofences().
        return PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    /**
     * Adds geofences, which sets alerts to be notified when the device enters or exits one of the
     * specified geofences. Handles the success or failure results returned by addGeofences().
     */
    public void addGeofences() {
        if (!mGoogleApiClient.isConnected()) {
            Toast.makeText(this, getString(R.string.not_connected), Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            LocationServices.GeofencingApi.addGeofences(
                    mGoogleApiClient,
                    // The GeofenceRequest object.
                    getGeofencingRequest(),
                    // A pending intent that that is reused when calling removeGeofences(). This
                    // pending intent is used to generate an intent when a matched geofence
                    // transition is observed.
                    getGeofencePendingIntent()
            ).setResultCallback(this); // Result processed in onResult().
        } catch (SecurityException securityException) {
            // Catch exception generated if the app does not use ACCESS_FINE_LOCATION permission.
            logSecurityException(securityException);
        }
    }

    private void logSecurityException(SecurityException securityException) {
        Log.e(TAG, "Invalid location permission. " +
                "You need to use ACCESS_FINE_LOCATION with geofences", securityException);
    }

    /**
     * Load place information how marker in map.
     *
     * @param audioGuide place object
     */
    private void loadSites(AudioGuide audioGuide) {
        LatLng position = new LatLng(audioGuide.getLatitude(),
                audioGuide.getLongitude());
        Marker marker = map.addMarker(new MarkerOptions()
                .position(position)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_headphone_32px)));
        marker.setTag(new MarkerPlaceData( audioGuide.getId(), audioGuide.getTitle(), audioGuide.getEstado(), audioGuide.getPortada()));
    }

    private void focusInPlace(Integer audioGuideId) {
        if (audioGuideId != null) {
            AudioGuide audioGuide = AudioGuideDataProvider.getAudioGuide().get(audioGuideId);
            focusIn = new LatLng(audioGuide.getLatitude(), audioGuide.getLongitude());
        }
    }

    private void moveUbicationCam() {
        if (focusIn != null)
            ubicationCamera(focusIn);
        else if (mLastLocation != null)
            ubicationCamera(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Empty list for storing geofences.
        mGeofenceList = new ArrayList<>();

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            if (bundle.containsKey(ARG_PLACE_ID)) {
                focusInPlace(bundle.getInt(ARG_PLACE_ID));
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mGoogleApiClient == null || !mGoogleApiClient.isConnected()) {
            buildGoogleApiClient();
            mGoogleApiClient.connect();
        }

        if (map == null) {
            MapFragment mapFragment = (MapFragment) getFragmentManager()
                    .findFragmentById(R.id.map);

            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap retMap) {
        map = retMap;
        setUpMap();
        populateGeofenceList();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        Toast.makeText(this, "onConnected", Toast.LENGTH_SHORT).show();

//        mLocationRequest = new LocationRequest();
//        mLocationRequest.setInterval(1000);
//        mLocationRequest.setFastestInterval(1000);
//        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

//        //mLocationRequest.setSmallestDisplacement(0.1F);
//        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        moveUbicationCam();
        // Provides a simple way of getting a device's location and is well suited for
        // applications that do not require a fine-grained location and that do not need location
        // updates. Gets the best and most recent location currently available, which may be null
        // in rare cases when a location is not available.
        addGeofences();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onResult(@NonNull Status status) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (mLastLocation != null) {
            String origins = mLastLocation.getLatitude() + "," + mLastLocation.getLongitude();
            String destinations = marker.getPosition().latitude + "," + marker.getPosition().longitude;
            String url =
                    "https://maps.googleapis.com/maps/api/distancematrix/json" +
                            "?origins=" + origins +
                            "&destinations=" + destinations +
                            "&key=" + getString(R.string.distance_matrix_key);
            Log.i("URL", url);

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new ResponseDistanceMarker(marker),
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("ERROR: ", error.toString());
                        }
                    });
            ComunicationHelper.getInstance(this).addToRequestQueue(stringRequest);
        } else {
            Toast.makeText(this, R.string.distance_error, Toast.LENGTH_LONG).show();
        }
        return false;
    }

    static class ResponseDistanceMarker implements Response.Listener<String> {
        private Marker marker;

        ResponseDistanceMarker(Marker marker) {
            this.marker = marker;
        }

        @Override
        public void onResponse(String response) {
            StringReader strReaderResponse = new StringReader(response);
            DistanceMatrixHelperJson helperDistance = new DistanceMatrixHelperJson();

            try {
                DistanceMatrix distance = helperDistance.readJsonStream(strReaderResponse);
                if (!distance.getRows().isEmpty()) {
                    assert ((MarkerPlaceData) marker.getTag()) != null;
                    ((MarkerPlaceData) marker.getTag())
                            .setDistance(distance.getRows().get(0).getDistance().getText());
                    Log.i("TAG", "ENTRO");
                    marker.hideInfoWindow();
                    marker.showInfoWindow();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}