package com.turistory.android.activity.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.turistory.android.activity.service.MediaPlayerService.MediaPlayerBinder;


/**
 * Created by Cristóbal Romero
 * <https://github.com/Cromeror>
 * on 03/10/2016.
 */
public class ControllerMediaPlayerService {

    private static ServiceConnection serviceConnection;
    private static ControllerMediaPlayerService instance;
    private MediaPlayerService.MediaPlayerBinder mediaPlayerBinder;
    private MediaPlayerService mediaPlayerService;
    private Context context;
    private boolean connected = false;

    private ControllerMediaPlayerService() {

        serviceConnection = new ServiceConnection() {

            public void onServiceConnected(ComponentName className, IBinder service) {
                mediaPlayerBinder = (MediaPlayerBinder) service;
                mediaPlayerService = mediaPlayerBinder.getService();
                connected = true;
            }

            public void onServiceDisconnected(ComponentName className) {
                connected = false;
            }
        };
    }

    public static ControllerMediaPlayerService getInstance() {
        if (instance == null)
            instance = new ControllerMediaPlayerService();


        return instance;
    }

    public void playMediaPlayer() {
        mediaPlayerService.audioPlay();
    }

    public void pauseMediaPlayer() {
        mediaPlayerService.audioPause();
    }

    public void initService(Context context, Integer audioResource) {
        this.context = context;
        Intent intent = new Intent(context, MediaPlayerService.class);
        context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public boolean isConnected() {
        return connected;
    }
}
