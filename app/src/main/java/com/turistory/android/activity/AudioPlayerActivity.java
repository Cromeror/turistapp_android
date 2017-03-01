package com.turistory.android.activity;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jean.jcplayer.JcAudio;
import com.example.jean.jcplayer.JcPlayerService;
import com.example.jean.jcplayer.JcPlayerView;
import com.turistory.android.activity.view.adapter.AudioGuideRecyclerAdapter;
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
        addView();





/*        if (getIntent().getIntExtra(AudioGuideRecyclerAdapter.AUDIOGUIDE_ID, 0) >= 0) {
            loadDetail(getIntent().getIntExtra(AudioGuideRecyclerAdapter.AUDIOGUIDE_ID, 0));
        }*/

      /*  Bundle datos = this.getIntent().getExtras();
        Log.e(TAG, "Datos -------> " +
                datos);
        int pos = datos.getInt("posicion");
        Log.e(TAG, "Pos -------> " +
                pos);
        loadDetail(pos);


        Log.e(TAG, "Posicion -------> " +
                audioguide.getId());*/
        player = (JcPlayerView) findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();

        //jcAudios.add(JcAudio.createFromURL("url audio","http://www.villopim.com.br/android/Music_01.mp3"));
        //jcAudios.add(JcAudio.createFromAssets("Asset audio", "49.v4.mid"));
        jcAudios.add(JcAudio.createFromRaw("Torre del reloj", R.raw.audio_tower_clock));
        //jcAudios.add(JcAudio.createFromFilePath("File directory audio", this.getFilesDir() + "/" + "CANTO DA GRAÚNA.mp3"));
        //jcAudios.add(JcAudio.createFromAssets("I am invalid audio", "aaa.mid")); // invalid assets file
        player.initPlaylist(jcAudios);


//        jcAudios.add(JcAudio.createFromFilePath("test", this.getFilesDir() + "/" + "13.mid"));
//        jcAudios.add(JcAudio.createFromFilePath("test", this.getFilesDir() + "/" + "123123.mid")); // invalid file path
//        jcAudios.add(JcAudio.createFromAssets("49.v4.mid"));
//        jcAudios.add(JcAudio.createFromRaw(R.raw.a_203));
//        jcAudios.add(JcAudio.createFromRaw("a_34", R.raw.a_34));
//        player.initWithTitlePlaylist(jcAudios, "Awesome music");


//        jcAudios.add(JcAudio.createFromFilePath("test", this.getFilesDir() + "/" + "13.mid"));
//        jcAudios.add(JcAudio.createFromFilePath("test", this.getFilesDir() + "/" + "123123.mid")); // invalid file path
//        jcAudios.add(JcAudio.createFromAssets("49.v4.mid"));
//        jcAudios.add(JcAudio.createFromRaw(R.raw.a_203));
//        jcAudios.add(JcAudio.createFromRaw("a_34", R.raw.a_34));
//        player.initAnonPlaylist(jcAudios);

//        Adding new audios to playlist
//        player.addAudio(JcAudio.createFromURL("url audio","http://www.villopim.com.br/android/Music_01.mp3"));
//        player.addAudio(JcAudio.createFromAssets("49.v4.mid"));
//        player.addAudio(JcAudio.createFromRaw(R.raw.a_34));
//        player.addAudio(JcAudio.createFromFilePath(this.getFilesDir() + "/" + "121212.mmid"));

        player.registerInvalidPathListener(this);
        adapterSetup();

    }

    private void addView() {





    }



    @Override
    protected void onStart() {
        super.onStart();


    }

    private void loadDetail(int intExtra) {
/*        this.audioguide = AudioGuideDataProvider.getAudioGuide().get(intExtra);
        TextView title = (TextView) findViewById(R.id.title_audioplayer);
        TextView subtitle = (TextView) findViewById(R.id.subtitle_audioplayer);
        ImageView covermini = (ImageView) findViewById(R.id.covermini_audioplayer);
        title.setText(this.audioguide.getTitle());
        covermini.setImageResource(audioguide.getCover());
        subtitle.setText(audioguide.getSubtitle());*//*



       /* TextView title = (TextView) findViewById(R.id.title_place_detail);
        TextView description = (TextView) findViewById(R.id.description_place_detail);
        ImageView imagen = (ImageView) findViewById(R.id.image_toolbars);

        title.setText(place.getName());
        description.setText(place.getDescription());
        if (place.getCover() != null)
            imagen.setImageResource(place.getCover());*/
    }

    public void playAudio(JcAudio jcAudio){
        player.playAudio(jcAudio);

        Toast.makeText(this, player.getCurrentAudio().getOrigin().toString(), Toast.LENGTH_SHORT).show();
    }

    protected void adapterSetup() {
        audioAdapter = new AudioAdapter(this);
        //recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setAdapter(audioAdapter);
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
//        player.removeAudio(jcAudio);
//        player.next();
    }


}
