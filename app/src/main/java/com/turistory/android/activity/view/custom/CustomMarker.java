package com.turistory.android.activity.view.custom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.turistory.android.activity.AudioPlayerActivity;
import com.turistory.android.activity.R;
import com.turistory.android.activity.view.custom.data.MarkerPlaceData;

/**
 * @author Cristóbal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0
 */

public class CustomMarker implements GoogleMap.InfoWindowAdapter,
        GoogleMap.OnInfoWindowClickListener {
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
        ImageView portada = (ImageView) view.findViewById(R.id.image_portada_marker);
        TextView distance = (TextView) view.findViewById(R.id.text_distance);
        TextView estado = (TextView) view.findViewById(R.id.text_estado);
        if (marker.getTag() != null) {
            MarkerPlaceData placeData = (MarkerPlaceData) marker.getTag();

            if(placeData.getEstado() == 0){
                estado.setBackgroundColor(0xff1b5e20);
                estado.setText("GRATIS");
            }else {
                estado.setBackgroundColor(0xffb71c1c);
                estado.setText("BLOQUEADO");
            }


            portada.setImageResource(placeData.getPortada());

            title.setText(placeData.getTitle());
            distance.setText(String.format("Distance: %s", placeData.getDistance()));
            return view;
        }

        distance.setText((CharSequence) "Distance:");
        return view;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        if (marker.getTag() != null) {
            MarkerPlaceData placeData = (MarkerPlaceData) marker.getTag();

            if(placeData.getEstado() == 0){
                Intent intent = new Intent(activity, AudioPlayerActivity.class);
                intent.putExtra(AudioPlayerActivity.ARG_PLACE_ID, placeData.getId());
                activity.startActivity(intent);
            }else {

                Toast toast2 =
                        Toast.makeText(activity,"Bloqueado", Toast.LENGTH_SHORT);
                toast2.show();
            }


        }
    }
}
