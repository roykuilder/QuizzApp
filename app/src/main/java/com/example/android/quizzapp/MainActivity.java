package com.example.android.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /**
     * These variable are created static because we need them in other activities.
     */

    public static String nameValue;
    public static String emailValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * This is the onClick method for the Take the quiz button. It stores the values given in the EditText views.
         */

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.name_input);
                nameValue = name.getText().toString();

                EditText email = (EditText) findViewById(R.id.email_input);
                emailValue = email.getText().toString();

                Intent nextPage = new Intent(MainActivity.this, Quiz.class);
                startActivity(nextPage);
            }
        });
    }
}
