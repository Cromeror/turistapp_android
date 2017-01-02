package com.turistory.android.activity.service;

/**
 * Cristobal Romero Rossi <cristobalromerorossi@gmail.com>
 */

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Constants used in this sample.
 */
public final class Constants {

    private Constants() {
    }

    public static final String PACKAGE_NAME = "com.google.android.gms.location.Geofence";

    public static final String SHARED_PREFERENCES_NAME = PACKAGE_NAME + ".SHARED_PREFERENCES_NAME";

    public static final String GEOFENCES_ADDED_KEY = PACKAGE_NAME + ".GEOFENCES_ADDED_KEY";

    /**
     * Used to set an expiration time for a geofence. After this amount of time Location Services
     * stops tracking the geofence.
     */
    public static final long GEOFENCE_EXPIRATION_IN_HOURS = 12;

    /**
     * For this sample, geofences expire after twelve hours.
     */
    public static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS =
            GEOFENCE_EXPIRATION_IN_HOURS * 60 * 60 * 1000;
    public static final float GEOFENCE_RADIUS_IN_METERS = 1609; // 1 mile, 1.6 km

    /**
     * Map for storing information about airports in the San Francisco bay area.
     */
    public static final HashMap<String, LatLng> BAY_AREA_LANDMARKS = new HashMap<String, LatLng>();

    static {
        // San Francisco International Airport.
        BAY_AREA_LANDMARKS.put("Tecnologico_confenalco", new LatLng(10.406324, -75.511166));
        BAY_AREA_LANDMARKS.put("clock_tower", new LatLng(10.423030, -75.549166));
        BAY_AREA_LANDMARKS.put("ivan_villamil", new LatLng(10.411598, -75.535374));
        BAY_AREA_LANDMARKS.put("cristobal", new LatLng(10.414172, -75.465441));

    }
}
