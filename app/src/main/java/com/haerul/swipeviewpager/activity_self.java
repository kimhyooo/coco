package com.haerul.swipeviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class activity_self extends AppCompatActivity {
    RadioButton qestion1_choice1, qestion2_choice1, qestion3_choice1, qestion4_choice1, qestion5_choice1, qestion6_choice1, qestion7_choice1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self);
    }

    //결과보기 버튼 누르면
    public void submit_answers(View view){
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int answer6_score;
        int answer7_score;
        int final_score;

    //1번
        Boolean answer1;
        qestion1_choice1 = (RadioButton) this.findViewById(R.id.qestion1_choice1);
        answer1 = qestion1_choice1.isChecked();
        if (answer1) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }
    //2번
        Boolean answer2;
        qestion2_choice1 = (RadioButton) this.findViewById(R.id.qestion2_choice1);
        answer2 = qestion2_choice1.isChecked();
        if (answer2) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }
    //3번
        Boolean answer3;
        qestion3_choice1 = (RadioButton) this.findViewById(R.id.qestion3_choice1);
        answer3 = qestion3_choice1.isChecked();
        if (answer3) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }
    //4번
        Boolean answer4;
        qestion4_choice1 = (RadioButton) this.findViewById(R.id.qestion4_choice1);
        answer4 = qestion4_choice1.isChecked();
        if (answer4) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }
    //5번
        Boolean answer5;
        qestion5_choice1 = (RadioButton) this.findViewById(R.id.qestion5_choice1);
        answer5 = qestion5_choice1.isChecked();
        if (answer5) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }
    //6번
        Boolean answer6;
        qestion6_choice1 = (RadioButton) this.findViewById(R.id.qestion6_choice1);
        answer6 = qestion6_choice1.isChecked();
        if (answer6) {
            answer6_score = 1;
        } else {
            answer6_score = 0;
        }
    //7번
        Boolean answer7;
        qestion7_choice1 = (RadioButton) this.findViewById(R.id.qestion7_choice1);
        answer7 = qestion7_choice1.isChecked();
        if (answer7) {
            answer7_score = 1;
        } else {
            answer7_score = 0;
        }
    //최종 점수
        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score +
                answer6_score + answer7_score;
    }
}