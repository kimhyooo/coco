package com.haerul.swipeviewpager;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class DetailActivity extends AppCompatActivity {

    int count=Adapter.a;
    ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView = findViewById(R.id.textView);
        poster = findViewById(R.id.poster);
        ImageView post_2 = findViewById(R.id.post_2);

        //비디오
        VideoView video_beha = findViewById(R.id.video_beha);
        String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.behavior_video;
        Uri uri = Uri.parse(videoPath);
        video_beha.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        video_beha.setMediaController(mediaController);
        mediaController.setAnchorView(video_beha);

        textView.setText(getIntent().getStringExtra("param"));

        if(count==0){
            video_beha.setVisibility(View.VISIBLE);
            post_2.setVisibility(View.VISIBLE);
        }

        if(count==1){
            poster.setVisibility(View.VISIBLE);
        }

        if(count==2){
            Intent intent = new Intent(DetailActivity.this, activity_self.class);
            startActivity(intent);
        }

        if(count==3){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ncov.mohw.go.kr/"));
            startActivity(intent);
        }








    }
}
