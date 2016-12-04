package com.turistory.android.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.turistory.android.activity.view.adapter.PreviewGalleryRecyclerAdapter;

public class RouteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PreviewGalleryRecyclerAdapter adapter = new PreviewGalleryRecyclerAdapter(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.previewGalleryRecyclerView);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(RouteDetailActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);

    }
}
