package com.haerul.swipeviewpager;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class activity_splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView quiz_image = (ImageView)findViewById(R.id.corona_image);
        ImageView quiz_word = (ImageView)findViewById(R.id.corona_word);

        Animation animation_image = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.image_move);
        Animation animation_word = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.word_move);
        quiz_image.startAnimation(animation_image);
        quiz_word.startAnimation(animation_word);

        startLoading();
    }

    private void startLoading(){
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },3000);
    }
}
