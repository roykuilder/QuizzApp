package com.example.android.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.widget.Toast.makeText;


public class BonusQuestions extends AppCompatActivity {

    private boolean checked = true;
    private int albumAnswer = 47;
    public static String congratulations;
    private EditText albumNumber;
    private int bonusQuestionScore;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;

    CheckBox albumCheckBox1;
    CheckBox albumCheckBox2;
    CheckBox albumCheckBox3;
    CheckBox albumCheckBox4;


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

        albumNumber = (EditText) findViewById(R.id.album_number_input);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checked) {
                    Toast checkFirst = makeText(BonusQuestions.this, "Check the answer first.", Toast.LENGTH_LONG);
                    checkFirst.show();
                } else {
                    nextPage();
                }
            }
        });

        findViewById(R.id.check_bonus_questions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checked) {
                    checked = false;

                    /** First check if City Question had answer. If not the else command display a toast. **/
                    if (radio1.isChecked() || radio2.isChecked() || radio3.isChecked()) {

                        /** Then check if album question has answer. if not display toast. */
                        if (albumNumber.getText().toString().equals(null) || albumNumber.getText().toString().equals("")) {
                            makeText(BonusQuestions.this, "please enter something in text box", Toast.LENGTH_LONG).show();
                            checked = true;
                        } else {
                            scoreCityQuestion();
                            scoreAlbumQuestion();
                            scoreCheckboxQuestion();
                            calcScore();
                            showResult();
                        }
                    }

                    /** If city question has no answer. Display toast. */
                    else {
                        Toast plsPickCity = makeText(BonusQuestions.this, "Please pick a City", Toast.LENGTH_LONG);
                        plsPickCity.show();
                        checked = true;
                    }
                } else {
                    showResult();
                }
            }
        });

    }

    private void showResult() {
        Toast result = Toast.makeText(BonusQuestions.this, congratulations, Toast.LENGTH_LONG);
        result.show();
    }

    private void scoreCityQuestion() {
        if (radio2.isChecked()) {
            bonusQuestionScore++;
        }
    }

    private void scoreAlbumQuestion() {
        int numberGiven = Integer.parseInt(albumNumber.getText().toString());
        int albumResult = albumAnswer - numberGiven;
        if (albumResult == 0) {
            bonusQuestionScore++;
        }
    }

    private void scoreCheckboxQuestion() {
        if (albumCheckBox1.isChecked() && albumCheckBox3.isChecked()) {
            bonusQuestionScore++;
        }
    }

    private void nextPage() {
        Intent resultPage = new Intent(BonusQuestions.this, Result.class);
        startActivity(resultPage);
    }

    private void calcScore() {
        int result = 0;
        for (int i = 0; i < Quiz.score.length; i++) {
            if (Quiz.score[i]) {
                result++;
            }
        }
        result = result + bonusQuestionScore;

        /**
         * Here is the construction of the final text. It take in two variables
         * - nameValue - for the name of the person taking the quiz
         * - result - for the amount of good answers
         */
        congratulations = getResources().getString(R.string.congratulations_part1) + " "
                + MainActivity.nameValue + "!" + "\n \n"
                + getResources().getString(R.string.congratulations_part2) + " "
                + result + " "
                + getResources().getString(R.string.congratulations_part3);
    }
}
