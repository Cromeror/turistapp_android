package com.turistory.android.activity.service;


import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import com.turistory.android.activity.R;


public class MediaPlayerService extends Service implements MediaPlayer.OnPreparedListener{

    private final IBinder mBinder = new MediaPlayerBinder();
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, R.raw.audio_tower_clock);
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public void audioPlay(){
        mediaPlayer.start();
    }

    public void audioPause(){
        mediaPlayer.pause();
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
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
         * @return
         */
        public MediaPlayerService getService() {
            return MediaPlayerService.this;
        }
    }
}