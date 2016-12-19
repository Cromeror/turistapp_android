package com.turistory.android.activity.service;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;


public class MediaPlayerService extends Service implements MediaPlayer.OnPreparedListener {

    private final IBinder mBinder = new MediaPlayerBinder();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    public class MediaPlayerBinder extends Binder {

        /**
         * Return this instance of LocalService so clients can call public methods
         *
         * @return
         */
        public MediaPlayerService getService() {
            return MediaPlayerService.this;
        }
    }
}