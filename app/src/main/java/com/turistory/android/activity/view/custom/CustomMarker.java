package com.turistory.android.activity.view.custom;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.turistory.android.activity.R;
import com.turistory.android.communication.ComunicationHelper;

/**
 * @author Cristóbal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0
 */

public class CustomMarker implements GoogleMap.InfoWindowAdapter {
    private final Activity activity;

    public CustomMarker(Activity activity) {
        this.activity = activity;
    }

    /**
     * @param origin
     * @param destinations
     */
    private void getRequest(String origin, String... destinations) {
        String url =
                "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Seattle&destinations=San+Francisco&key=" +
                        activity.getString(R.string.distance_matrix_key);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("MENSAJE: ", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("ERROR: ", error.toString());
                    }
                });
        ComunicationHelper.getInstance(activity).addToRequestQueue(stringRequest);
    }

    @Override
    public View getInfoWindow(Marker marker) {

        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = activity.getLayoutInflater().inflate(R.layout.custom_marker, null);
        return view;
    }
}
