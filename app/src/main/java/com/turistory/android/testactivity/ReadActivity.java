package com.turistory.android.testactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
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
        setSupportActionBar(toolbar);
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
        //toolbar.setSubtitle("Información general");
        //toolbar.setTitleTextColor(0x00ffffff);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar actionBarV7 = getSupportActionBar();
        // Enable the Up button
        assert actionBarV7 != null;
        actionBarV7.setTitle(audioguide.getTitle());
        actionBarV7.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("NAVIGATE_UP", item.toString());
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                upIntent.putExtra(AudioPlayerActivity.ARG_PLACE_ID, audioguide.getId());
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadDetail(int intExtra) {
        this.audioguide = AudioGuideDataProvider.getAudioGuide().get(intExtra);

        TextView guion = (TextView) findViewById(R.id.textread);
        ImageView cover = (ImageView) findViewById(R.id.expandedImage);

        guion.setText(this.audioguide.getGuion());
        cover.setImageResource(audioguide.getPortada());
    }

}
