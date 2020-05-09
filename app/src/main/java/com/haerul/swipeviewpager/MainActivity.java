package com.haerul.swipeviewpager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.post_1, "예방수칙", "코로나-19를 예방하려면 어떻게 해야할까?"));
        models.add(new Model(R.drawable.post_2, "Sticker", "Sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"));
        models.add(new Model(R.drawable.post_3, "자가진단", "간단한 자가진단을 해봅시다."));
        models.add(new Model(R.drawable.post_4, "오늘의 코로나는", "Business cards are cards bearing business information about a company or individual."));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) { }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });
    }

    //코로나란 버튼
    public void corona_btn(View view){
        Intent intent = new Intent(MainActivity.this, activity_what_corona.class);
        startActivity(intent);
    }

    //웹페이지 띄우기
    public void page_btn(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ncov.mohw.go.kr/"));
        startActivity(intent);
    }

    public void call_btn(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:1339"));
        startActivity(intent);
    }
}
