package com.example.myapplication.util;

import android.content.Context;
import android.widget.ImageView;

import com.example.myapplication.Models.ClusterMarker;
import com.example.myapplication.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.ui.IconGenerator;

public class MyClusterManagerRenderer extends DefaultClusterRenderer<ClusterMarker> {

    private final IconGenerator iconGenerator;
    private final ImageView imageView;
    private final int markerWidth;
    private final int markerHeight;

    public MyClusterManagerRenderer(Context context, GoogleMap map, ClusterManager<ClusterMarker> clusterManager, IconGenerator iconGenerator, ImageView imageView, int markerWidth, int markerHeight) {
        super(context, map, clusterManager);
        this.iconGenerator = iconGenerator;
        this.imageView = imageView;
        this.markerWidth = markerWidth;
        this.markerHeight = markerHeight;
        iconGenerator = new IconGenerator(context.getApplicationContext());
        imageView = new ImageView(context.getApplicationContext());
//        markerWidth = (int) context.getResources().getDimension();

    }


}
