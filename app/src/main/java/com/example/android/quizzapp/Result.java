package com.example.android.quizzapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.quizzapp.BonusQuestions.congratulations;
import static com.example.android.quizzapp.MainActivity.emailValue;
import static com.example.android.quizzapp.MainActivity.nameValue;


public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView background = (ImageView) findViewById(R.id.background_image);
        background.setImageResource(R.drawable.bruce3);

        /**
         * Here is the construction of the final text. It take in two variables
         * - nameValue - for the name of the person taking the quiz
         * - result - for the amount of good answers
         */
        TextView mainView = (TextView) findViewById(R.id.main_view);
        mainView.setText(BonusQuestions.congratulations);

        /**
         * The text for the different view is taken from strings and variables from the first screen.
         */
        TextView button = (TextView) findViewById(R.id.button);
        button.setText(getResources().getString(R.string.mail_results));

        EditText name = (EditText) findViewById(R.id.name_input);
        name.setText(nameValue);

        EditText email = (EditText) findViewById(R.id.email_input);
        email.setText(MainActivity.emailValue);

        /**
         * This is the emailIntent for the send email button.
         */
        Intent sendEmail = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", emailValue, null));
        sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        sendEmail.putExtra(Intent.EXTRA_TEXT, congratulations);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendEmail = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", emailValue, null));
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                sendEmail.putExtra(Intent.EXTRA_TEXT, congratulations);
                startActivity(Intent.createChooser(sendEmail, "Send email..."));
            }
        });


    }
}
