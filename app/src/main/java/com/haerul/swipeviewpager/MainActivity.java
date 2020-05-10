package com.haerul.swipeviewpager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    TextView date_text, mask_text; //mask_text는 오늘 날짜~~입니다 알려주는
    EditText edit_text;
    Button number_btn;
    ImageView mask_image;

    int a=0, b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //날짜
        date_text = findViewById(R.id.date_text);
        SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일");
        Date time = new Date();
        String time2 = format2.format(time);
        date_text.setText(time2);

        //날짜 --- 오늘은 끝자리~~~이다.
        SimpleDateFormat format3 = new SimpleDateFormat("EE");
        mask_text = findViewById(R.id.mask_text);
        Date time3 = new Date();
        final String time33 = format3.format(time3);
        if(time33.equals("월")) {
            mask_text.setText("1, 6");
            this.a = 1; this.b = 6;
        }
        else if(time33.equals("화")) {
            mask_text.setText("2, 7");
            this.a = 2; this.b = 7;
        }
        else if(time33.equals("수")) {
            mask_text.setText("3, 8");
            this.a = 3; this.b = 8;
        }
        else if(time33.equals("목")) {
            mask_text.setText("4, 9");
            this.a = 4; this.b = 9;
        }
        else if(time33.equals("금")) {
            mask_text.setText("5, 0");
            this.a = 5; this.b = 0;
        }

        //사용자 년도 입력받고 사진 나오는거
        edit_text = findViewById(R.id.edit_text); //edit값 가져오기
        mask_image = findViewById(R.id.mask_image);//마스크 이미지
        number_btn = findViewById(R.id.number_btn);
        number_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edit_text.getText().toString(); //입력된 값 가져오기
                int result = Integer.parseInt(str);
                result = result%1000;
                result = result%100;
                result = result%10;
                if(result==a||result==b){
                    mask_image.setVisibility(View.VISIBLE);
                }
                else mask_image.setVisibility(View.INVISIBLE);
            }
        });

        //스플래쉬
        Intent intent = new Intent(this, activity_splash.class);
        startActivity(intent);

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

    //자가진단 페이지로
    public void self_btn(View view){
        Intent intent = new Intent(MainActivity.this, activity_self.class);
        startActivity(intent);
    }

    //다이얼 전화걸기
    public void call_btn(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:1339"));
        startActivity(intent);
    }
}
