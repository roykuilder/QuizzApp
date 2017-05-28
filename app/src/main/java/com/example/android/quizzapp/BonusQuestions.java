package com.example.android.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class BonusQuestions extends AppCompatActivity {

    private boolean checked = true;
    private int albumAnswer = 47;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;

    CheckBox albumCheckBox1;
    CheckBox albumCheckBox2;
    CheckBox albumCheckBox3;
    CheckBox albumCheckBox4;

    public static int bonusQuestionScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonus_question);

        radio1 = (RadioButton) findViewById(R.id.radio_button_1);
        radio2 = (RadioButton) findViewById(R.id.radio_button_2);
        radio3 = (RadioButton) findViewById(R.id.radio_button_3);

        albumCheckBox1 = (CheckBox) findViewById(R.id.album_checkbox1);
        albumCheckBox2 = (CheckBox) findViewById(R.id.album_checkbox2);
        albumCheckBox3 = (CheckBox) findViewById(R.id.album_checkbox3);
        albumCheckBox4 = (CheckBox) findViewById(R.id.album_checkbox4);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checked) {
                    Toast checkFirst = Toast.makeText(BonusQuestions.this, "Check the answer first.", Toast.LENGTH_LONG);
                    checkFirst.show();
                } else {
                    if (albumCheckBox1.isChecked() && albumCheckBox3.isChecked()) {
                        bonusQuestionScore++;
                        nextPage();
                    } else {
                        nextPage();
                    }
                }
            }
        });


        findViewById(R.id.check_bonus_questions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checked = false;
                changeColor();

                if (radio1.isChecked()) {
                    radio1.setBackgroundColor(ContextCompat.getColor(BonusQuestions.this, R.color.background_false));
                    radio2.setBackgroundColor(ContextCompat.getColor(BonusQuestions.this, R.color.background_correct));
                } else if (radio2.isChecked()) {
                    radio2.setBackgroundColor(ContextCompat.getColor(BonusQuestions.this, R.color.background_correct));
                    bonusQuestionScore++;
                } else if (radio3.isChecked()) {
                    radio3.setBackgroundColor(ContextCompat.getColor(BonusQuestions.this, R.color.background_false));
                    radio2.setBackgroundColor(ContextCompat.getColor(BonusQuestions.this, R.color.background_correct));
                } else {
                    Toast dontForget = Toast.makeText(BonusQuestions.this, "Please pick a City", Toast.LENGTH_LONG);
                    dontForget.show();
                    checked = true;
                }

            }
        });

    }


    private void changeColor() {
        EditText albumNumber = (EditText) findViewById(R.id.album_number_input);
        if (albumNumber.getText().toString().equals(null) || albumNumber.getText().toString().equals("")) {
            Toast.makeText(this, "please enter something in text box", Toast.LENGTH_LONG).show();
        } else {
            int numberGiven = Integer.parseInt(albumNumber.getText().toString());
            int albumResult = albumAnswer - numberGiven;
            if (albumResult == 0) {
                albumNumber.setBackgroundColor(ContextCompat.getColor(BonusQuestions.this, R.color.background_correct));
                bonusQuestionScore++;
            } else {
                albumNumber.setBackgroundColor(ContextCompat.getColor(BonusQuestions.this, R.color.background_false));
            }

        }
    }

    private void nextPage() {
        Intent resultPage = new Intent(BonusQuestions.this, Result.class);
        startActivity(resultPage);
    }

}
