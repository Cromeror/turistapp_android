package com.turistory.android.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jean.jcplayer.JcAudio;
import com.example.jean.jcplayer.JcPlayerService;
import com.example.jean.jcplayer.JcPlayerView;
import com.turistory.android.activity.view.adapter.AudioAdapter;
import com.turistory.android.data.AudioGuide;
import com.turistory.android.data.AudioGuideDataProvider;

import java.util.ArrayList;

public class AudioPlayerActivity extends AppCompatActivity  implements JcPlayerService.OnInvalidPathListener{
    private AudioGuide audioguide;
    private AudioAdapter audioAdapter;
    private JcPlayerView player;
    private  ImageButton btnleer;
    protected final static String TAG = "AudioPlayer";
//implements JcPlayerService.OnInvalidPathListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Bundle datos = this.getIntent().getExtras();
        Log.e(TAG, "Datos -------> " +
                datos);
        int pos = datos.getInt("posicion");
        Log.e(TAG, "Pos -------> " +
                pos);
        loadDetail(pos);


        Log.e(TAG, "Posicion -------> " +
                audioguide.getId());
        player = (JcPlayerView) findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();


        jcAudios.add(JcAudio.createFromRaw(audioguide.getTitle(), audioguide.getAudio()));
        player.initPlaylist(jcAudios);
        player.registerInvalidPathListener(this);
        adapterSetup();

        ImageButton BtnLeer = (ImageButton) findViewById(R.id.bottombar_leer);
        BtnLeer.setOnClickListener(getOnclicListenerBtnLeer());

    }

    private View.OnClickListener getOnclicListenerBtnLeer() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createSimpleDialog();
            }
        };
    }

    public AlertDialog createSimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Titulo")
                .setMessage("El Mensaje para el usuario")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               // listener.onPossitiveButtonClick();
                            }
                        })
                .setNegativeButton("CANCELAR",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                              //  listener.onNegativeButtonClick();
                            }
                        });

        return builder.create();
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    private void loadDetail(int intExtra) {
       this.audioguide = AudioGuideDataProvider.getAudioGuide().get(intExtra);
        TextView title = (TextView) findViewById(R.id.title_audioplayer);
        TextView subtitle = (TextView) findViewById(R.id.subtitle_audioplayer);
        ImageView covermini = (ImageView) findViewById(R.id.covermini_audioplayer);
        ImageView cover = (ImageView) findViewById(R.id.cover_audioplayer);
        title.setText(this.audioguide.getTitle());
        covermini.setImageResource(audioguide.getCover());
        subtitle.setText(audioguide.getSubtitle());
        cover.setImageResource(audioguide.getCover());

    }

    public void playAudio(JcAudio jcAudio){
        player.playAudio(jcAudio);

        Toast.makeText(this, player.getCurrentAudio().getOrigin().toString(), Toast.LENGTH_SHORT).show();
    }

    protected void adapterSetup() {
        audioAdapter = new AudioAdapter(this);
        audioAdapter.setupItems(player.getMyPlaylist());
    }

    @Override
    public void onPause(){
        super.onPause();
        player.createNotification();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.kill();
    }

    @Override
    public void onPathError(JcAudio jcAudio) {
        Toast.makeText(this, jcAudio.getPath() + " with problems", Toast.LENGTH_LONG).show();
    }


}
