package com.turistory.android.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.turistory.android.activity.view.adapter.PreviewGalleryRecyclerAdapter;

public class RouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        PreviewGalleryRecyclerAdapter adapter = new PreviewGalleryRecyclerAdapter(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.previewGalleryRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
