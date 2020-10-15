package com.pattersonhs.quizapp2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView questionTV;
    Button trueButton;
    Button falseButton;
    Button nextButton;
    Toast toast;

    Question q0, q1, q2, q3, q4;
    Question[] questions;
    Question currentQ;

    String message;
    int currentQnumber;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = (TextView) findViewById(R.id.questionTV);
        trueButton = (Button) findViewById(R.id.trueButton);
        falseButton = (Button) findViewById(R.id.falseButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        score = 0;
        currentQnumber = 0;
        q0 = new Question(getString(R.string.q0Text), true);
        q1 = new Question(getString(R.string.q1Text), false);
        q2 = new Question(getString(R.string.q2Text), true);
        q3 = new Question(getString(R.string.q3Text), true);
        q4 = new Question(getString(R.string.q4Text), false);
        questions = new Question[] {q0,q1,q2,q3,q4};
        currentQ = questions[currentQnumber];

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQ.getQAnswer()) {
                    message = getString(R.string.correctMessage);
                    score++;
                }
                else {
                    message = getString(R.string.incorrectMessage);
                }
                toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQ.getQAnswer()) {
                    message = getString(R.string.incorrectMessage);
                }
                else {
                    message = getString(R.string.correctMessage);
                    score++;
                }
                toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQnumber++;
                if (currentQnumber<5) {
                    currentQ = questions[currentQnumber];
                    questionTV.setText(currentQ.getQWords());
                }
                else {
                    Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                    intent.putExtra("scoreName", score);
                    startActivity(intent);
                }
            }
        });


    }
}