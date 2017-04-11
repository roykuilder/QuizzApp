package com.example.android.quizzapp;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Kuilder on 08-04-17.
 */

public class Questions {

    private int mQuestion;
    private int mAnswer1;
    private int mAnswer2;
    private int mAnswer3;
    private int mCorrectAnswer;

    public Questions(int question, int answer1, int answer2, int answer3, int correctAnswer){
        mQuestion = question;
        mAnswer1 = answer1;
        mAnswer2 = answer2;
        mAnswer3 = answer3;
        mCorrectAnswer = correctAnswer;
    }

    /**
     * There are the getter methods.
     */

    public int getQuestion(){
        return mQuestion;
    }

    public int getAnswer1(){
        return mAnswer1;
    }

    public int getAnswer2(){
        return mAnswer2;
    }

    public int getAnswer3(){
        return mAnswer3;
    }

    public int getCorrectAnswer(){
        return mCorrectAnswer;
    }
}
