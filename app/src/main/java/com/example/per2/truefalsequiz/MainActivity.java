package com.example.per2.truefalsequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_SENT_SCORE = "Your score is ";
    private Button buttonfalse;
    private Button buttontrue;
    private TextView question;
    private Quiz theQuiz;
    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeQuiz();
        wireWidgets();
        setListeners();
        Log.d("Whale", "onCreate: " + "Whale");
        displayNextQuestion(theQuiz);

    }

    private void displayNextQuestion(Quiz truefalsequiz) {
        if (truefalsequiz.isThereAnotherQ) {
            Question i = truefalsequiz.getCurrent();

        } else {
            Intent intentFinishGame = new Intent(MainActivity.this, EndGameActivity.class);
            intentFinishGame.putExtra(EXTRA_SENT_SCORE, theQuiz.getScore());
            startActivity(intentFinishGame);
        }

    }

    private void setListeners() {
        buttontrue.setOnClickListener(this);
        buttonfalse.setOnClickListener(this);
    }

    private void wireWidgets() {
        buttonfalse = findViewById(R.id.button_main_false);
        buttontrue = findViewById(R.id.button_main_true);
        question = findViewById(R.id.textView_main_question);
    }

    public void initializeQuiz() {
        InputStream trueFalse = getResources().openRawResource(R.raw.questions);
        String sxml = readTextFile(trueFalse);
        // create a gson object
        Gson gson = new Gson();
// read your json file into an array of questions
        Question[] questions = gson.fromJson(sxml, Question[].class);
// convert your array to a list using the Arrays utility class
        List<Question> questionList = Arrays.asList(questions);
// verify that it read everything properly
        Log.d("Quiz", "onCreate: " + questionList.toString());
        theQuiz = new Quiz(questionList);
    }


    public String readTextFile(InputStream inputStream) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_main_true:
                answerQuestion(true);
                break;
            case R.id.button_main_false:
                answerQuestion(false);
                break;
        }
    }

    private void answerQuestion(boolean b) {
        for (int i = 0; i <= 10; i++)
        {
            if (theQuiz.getCurrent().getAnswer())
            {
                score += 1;
                displayNextQuestion(theQuiz);
            }
            else
                {
                displayNextQuestion(theQuiz);
            }
        }
    }
}



