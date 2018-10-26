package com.example.per2.truefalsequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity
{
    private TextView textViewScore;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        textViewScore = findViewById(R.id.textView_main_question);
        textViewScore.setText("Your score is " + getIntent().getStringExtra(MainActivity.EXTRA_SENT_SCORE + "/10"));
    }

}

