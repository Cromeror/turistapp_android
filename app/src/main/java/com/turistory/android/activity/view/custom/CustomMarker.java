package com.turistory.android.activity.view.custom;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.vision.text.Text;
import com.turistory.android.activity.R;
import com.turistory.android.activity.view.custom.data.MarkerPlaceData;
import com.turistory.android.communication.ComunicationHelper;
import com.turistory.android.communication.DistanceMatrixHelperJson;
import com.turistory.android.communication.dto.distance_matrix.DistanceMatrix;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author Cristóbal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0
 */

public class CustomMarker implements GoogleMap.InfoWindowAdapter {
    private final Activity activity;

    public CustomMarker(Activity activity) {
        this.activity = activity;
    }

    @Override
    public View getInfoWindow(Marker marker) {

        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = activity.getLayoutInflater().inflate(R.layout.custom_marker, null);
        TextView title = (TextView) view.findViewById(R.id.text_title);
        TextView distance = (TextView) view.findViewById(R.id.text_distance);
        if (marker.getTag() != null) {
            MarkerPlaceData placeData = (MarkerPlaceData) marker.getTag();

            title.setText(placeData.getTitle());
            distance.setText(String.format("Distance: %s", placeData.getDistance()));
            return view;
        }

        distance.setText((CharSequence) "Distance:");
        return view;
    }
}
