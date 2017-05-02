package com.turistory.android.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jean.jcplayer.JcAudio;
import com.example.jean.jcplayer.JcPlayerService;
import com.example.jean.jcplayer.JcPlayerView;
import com.turistory.android.activity.fragment.CoverAudioFragment;
import com.turistory.android.activity.view.adapter.AudioAdapter;
import com.turistory.android.data.AudioGuide;
import com.turistory.android.data.AudioGuideDataProvider;

import java.util.ArrayList;

public class AudioPlayerActivity extends FragmentActivity
        implements CoverAudioFragment.OnFragmentInteractionListener, JcPlayerService.OnInvalidPathListener {

    private AudioGuide audioguide;
    private AudioAdapter audioAdapter;
    private JcPlayerView player;
    private ImageButton btnleer;
    private Context context;
    protected final static String TAG = "AudioPlayer";
    public final static String ARG_PLACE_ID = "PLACE_ID";
    private CoverGalleryAdapter mCoverGalleryAdapter;
    private ViewPager mViewPager;
//implements JcPlayerService.OnInvalidPathListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        //Others
        Bundle datos = this.getIntent().getExtras();
        Log.e(TAG, "Datos -------> " +
                datos);
        int pos = datos.getInt(ARG_PLACE_ID);
        Log.e(TAG, "Pos -------> " +
                pos);
        loadDetail(pos);

        //Swipe Gallery
        mCoverGalleryAdapter = new CoverGalleryAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager_cover_media);
        mViewPager.setAdapter(mCoverGalleryAdapter);
        //

        Log.e(TAG, "Posicion -------> " +
                audioguide.getId());
        player = (JcPlayerView) findViewById(R.id.jcplayer);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();

        jcAudios.add(JcAudio.createFromRaw(audioguide.getTitle(), audioguide.getAudio()));
        player.initPlaylist(jcAudios);
        // player.initAnonPlaylist(jcAudios);
        //playAudio(jcAudios.get(0));
        player.registerInvalidPathListener(this);
        adapterSetup();

        ImageButton btnLeer = (ImageButton) findViewById(R.id.bottombar_leer);
        ImageButton btnMap = (ImageButton) findViewById(R.id.bottombar_map);
        btnLeer.setOnClickListener(getOnclicListenerBtnLeer());
        btnMap.setOnClickListener(goToMap());
    }

    private View.OnClickListener getOnclicListenerBtnLeer() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
                Intent intent = new Intent(AudioPlayerActivity.this, ReadActivity.class);
                intent.putExtra("id", audioguide.getId());
                startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
            }
        };
    }

    private View.OnClickListener goToMap() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
                Intent intent = new Intent(AudioPlayerActivity.this, MapActivity.class);
                intent.putExtra(MapActivity.ARG_PLACE_ID, audioguide.getId());
                startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
            }
        };
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
        //ImageView cover = (ImageView) findViewById(R.id.cover_audioplayer);
        title.setText(this.audioguide.getTitle());
        covermini.setImageResource(audioguide.getPortada());
        subtitle.setText(audioguide.getRuta());
        //cover.setImageResource(audioguide.getCover());
    }

    public void playAudio(JcAudio jcAudio) {
        player.playAudio(jcAudio);
    }

    protected void adapterSetup() {
        audioAdapter = new AudioAdapter(this);
        audioAdapter.setupItems(player.getMyPlaylist());
    }

    @Override
    public void onPause() {
        super.onPause();
        player.pause();
        //player.createNotification();
    }

    @Override
    public void onResume() {
        super.onResume();
        //player.createNotification();
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class CoverGalleryAdapter extends FragmentStatePagerAdapter {
        public CoverGalleryAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = CoverAudioFragment.newInstance(audioguide.getGallery().get(i));
            Log.i("ADAPTER", i + "");
            return fragment;
        }

        @Override
        public int getCount() {
            return audioguide.getGallery().size();
        }
    }
}