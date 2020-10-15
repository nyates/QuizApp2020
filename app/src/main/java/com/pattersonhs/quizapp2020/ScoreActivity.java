package com.pattersonhs.quizapp2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class ScoreActivity extends AppCompatActivity {

    TextView scoreTV;
    Intent intent;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        intent = getIntent();
        score = intent.getIntExtra("scoreName", 0);

        scoreTV = (TextView) findViewById(R.id.scoreTV);
        scoreTV.setText(getString(R.string.scoreMessage) + score);

    }
}