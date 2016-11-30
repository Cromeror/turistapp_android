package com.turistory.android.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.turistory.android.activity.view.adapter.PreviewGalleryRecyclerAdapter;

public class RouteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_detail);

        PreviewGalleryRecyclerAdapter adapter = new PreviewGalleryRecyclerAdapter(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.previewGalleryRecyclerView);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(RouteDetailActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
    }
}
