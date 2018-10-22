package com.example.per2.truefalsequiz;

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


public class MainActivity extends AppCompatActivity {
    private Button buttonfalse;
    private Button buttontrue;
    private TextView question;
    private Quiz theQuiz;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeQuiz();
        wireWidgets();
        setListeners();
        Log.d("Whale", "onCreate: " + "Whale");
        displayNextQuestion();

    }

    private void displayNextQuestion(Quiz truefalsequiz)
    {
        if(truefalsequiz.isThereAnotherQ)
            int i = truefalsequiz.getQuestion();



    }

    private void setListeners()
    {
        TrueFalseQuiz quizListener = new TrueFalseQuiz();
        buttontrue.setOnClickListener(quizListener);
        buttonfalse.setOnClickListener(quizListener);
    }

    private void wireWidgets()
    {
        Button buttonfalse = findViewById(R.id.button_main_false);
        Button buttontrue = findViewById(R.id.button_main_true);
        TextView question = findViewById(R.id.textView_main_question);
    }

    public void initializeQuiz()
    {
        InputStream trueFalse = getResources().openRawResource(R.raw.questions);
        String sxml = readTextFile(trueFalse);
        // create a gson object
        Gson gson = new Gson();
// read your json file into an array of questions
        Question[] questions =  gson.fromJson(sxml, Question[].class);
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
    private class TrueFalseQuiz implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //get the id of the button that was clicked
            int id = v.getId();

        }
    }


}



