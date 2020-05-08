package com.haerul.swipeviewpager;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class activity_what_corona extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_corona);

        VideoView video_view = findViewById(R.id.video_view);
        String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.what_corona_video;
        Uri uri = Uri.parse(videoPath);
        video_view.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video_view.setMediaController(mediaController);
        mediaController.setAnchorView(video_view);
    }
}
