package com.turistory.android.activity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.turistory.android.data.AudioGuide;
import com.turistory.android.data.AudioGuideDataProvider;

public class ReadActivity extends AppCompatActivity {
    protected final static String TAG = "Read";
    private AudioGuide audioguide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //CollapsingToolbarLayout c = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);


        //c.setCollapsedTitleTextColor(0x00ffffff);


        Bundle datos = this.getIntent().getExtras();
        Log.e(TAG, "Datos -------> " +
                datos);
        int id = datos.getInt("id");
        Log.e(TAG, "id -------> " +
                id);
        loadDetail(id);


        Log.e(TAG, "Posicion -------> " +
                audioguide.getId());
        //c.setTitle("");
        //c.setExpandedTitleTextColor(ColorStateList.valueOf(0xffffffff));
        toolbar.setTitle(audioguide.getTitle());
        //toolbar.setSubtitle("Información general");
        //toolbar.setTitleTextColor(0x00ffffff);



        setSupportActionBar(toolbar);


    }

    private void loadDetail(int intExtra) {
        this.audioguide = AudioGuideDataProvider.getAudioGuide().get(intExtra);

        TextView guion = (TextView) findViewById(R.id.textread);
        ImageView cover = (ImageView) findViewById(R.id.expandedImage);

        guion.setText(this.audioguide.getGuion());
        cover.setImageResource(audioguide.getPortada());


    }

}
