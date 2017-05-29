package com.example.android.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.quizzapp.R.id.answer1;

public class Quiz extends AppCompatActivity {

    /**
     * variable are declared here so they are global.
     */

    ArrayList<Questions> quizData;
    int[] mCheckbox;
    public static boolean[] score = new boolean[7];
    int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        /**
         * This is where the ArrayList gets constructed and filled with the data of each question.
         */
        this.quizData = new ArrayList<Questions>();

        quizData.add(new Questions(R.string.q1q, R.string.q1a1, R.string.q1a2, R.string.q1a3, R.string.q1ca));
        quizData.add(new Questions(R.string.q2q, R.string.q2a1, R.string.q2a2, R.string.q2a3, R.string.q2ca));
        quizData.add(new Questions(R.string.q3q, R.string.q3a1, R.string.q3a2, R.string.q3a3, R.string.q3ca));
        quizData.add(new Questions(R.string.q4q, R.string.q4a1, R.string.q4a2, R.string.q4a3, R.string.q4ca));
        quizData.add(new Questions(R.string.q5q, R.string.q5a1, R.string.q5a2, R.string.q5a3, R.string.q5ca));
        quizData.add(new Questions(R.string.q6q, R.string.q6a1, R.string.q6a2, R.string.q6a3, R.string.q6ca));
        quizData.add(new Questions(R.string.q7q, R.string.q7a1, R.string.q7a2, R.string.q7a3, R.string.q7ca));

        mCheckbox = new int[10];

        mCheckbox[0] = R.id.checkbox1;
        mCheckbox[1] = R.id.checkbox2;
        mCheckbox[2] = R.id.checkbox3;
        mCheckbox[3] = R.id.checkbox4;
        mCheckbox[4] = R.id.checkbox5;
        mCheckbox[5] = R.id.checkbox6;
        mCheckbox[6] = R.id.checkbox7;

        /**
         * call the update method from the onCreate method to fill the view with the first question.
         */
        update();
    }


    /**
     * This method is called when one of the answers is clicked. It takes in the id of the view and switches to the right action.
     * It compares the value of the answer given and the correct answer from the quizData[Question].
     *
     * @param view
     */
    public void scoring(View view) {
        switch (view.getId()) {
            case answer1:
                if (getResources().getString(quizData.get(currentQuestion).getAnswer1()).equals(getResources().getString(quizData.get(currentQuestion).getCorrectAnswer()))) {
                    score[currentQuestion] = true;
                    logB();
                    currentQuestion++;
                    update();
                } else {
                    score[currentQuestion] = false;
                    logB();
                    currentQuestion++;
                    update();
                }
                break;


            case R.id.answer2:
                if (getResources().getString(quizData.get(currentQuestion).getAnswer2()).equals(getResources().getString(quizData.get(currentQuestion).getCorrectAnswer()))) {
                    score[currentQuestion] = true;
                    logB();
                    currentQuestion++;
                    update();
                } else {
                    score[currentQuestion] = false;
                    logB();
                    currentQuestion++;
                    update();
                }
                break;


            case R.id.answer3:
                if (getResources().getString(quizData.get(currentQuestion).getAnswer3()).equals(getResources().getString(quizData.get(currentQuestion).getCorrectAnswer()))) {
                    score[currentQuestion] = true;
                    logB();
                    currentQuestion++;
                    update();
                } else {
                    score[currentQuestion] = false;
                    logB();
                    currentQuestion++;
                    update();
                }
                break;


        }
    }

    /**
     * This method updates the Views to the next question from the ArrayList quizData.
     */
    public void update() {
        if (currentQuestion == quizData.size()) {
            bonusQuestions();
        } else {
            TextView answer1 = (TextView) findViewById(R.id.answer1);
            TextView answer2 = (TextView) findViewById(R.id.answer2);
            TextView answer3 = (TextView) findViewById(R.id.answer3);
            TextView question = (TextView) findViewById(R.id.question);
            answer1.setText(getResources().getString(quizData.get(currentQuestion).getAnswer1()));
            answer2.setText(getResources().getString(quizData.get(currentQuestion).getAnswer2()));
            answer3.setText(getResources().getString(quizData.get(currentQuestion).getAnswer3()));
            question.setText(getResources().getString(quizData.get(currentQuestion).getQuestion()));

            /**
             * This part changes the checkboxes to show the progress in the quiz.
             */

            int color = ContextCompat.getColor(this, R.color.colorPrimary);
            TextView box = (TextView) findViewById(mCheckbox[currentQuestion]);
            box.setBackgroundColor(color);
        }
    }

    /**
     * This method is used to check the behavior of the app while answering the questions.
     * It is not needed anymore but i leave it in here as a reminder.
     */
    public void logB() {
        Boolean mScore = score[currentQuestion];
        String mValue = mScore.toString();
        Log.v("score value", "score " + mValue);
    }

    /**
     * This method is called when there are no more questions
     */
    public void bonusQuestions() {
        Intent resultPage = new Intent(Quiz.this, BonusQuestions.class);
        startActivity(resultPage);
    }
}
