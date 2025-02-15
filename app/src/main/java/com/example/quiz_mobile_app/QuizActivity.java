package com.example.quiz_mobile_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    private TextView questionText, questionNumber;
    private RadioGroup optionsGroup;
    private Button nextButton, prevButton;

    private String[] questions = {
            "In what year did the United States host the FIFA World Cup for the first time?",
            "Who won the FIFA World Cup in 2018?"
    };
    private String[][] options = {
            {"1986", "1994", "2002", "2010"},
            {"Brazil", "France", "Germany", "Argentina"}
    };
    private int[] answers = {1, 1}; // Correct answers
    private int currentQuestion = 0;
    private int score = 0;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        userName = getIntent().getStringExtra("USER_NAME");

        questionText = findViewById(R.id.questionText);
        questionNumber = findViewById(R.id.questionNumber);
        optionsGroup = findViewById(R.id.optionsGroup);
        nextButton = findViewById(R.id.nextButton);
        prevButton = findViewById(R.id.prevButton);

        loadQuestion();

        nextButton.setOnClickListener(v -> {
            currentQuestion++;
            loadQuestion();
        });

        prevButton.setOnClickListener(v -> {
            currentQuestion--;
            loadQuestion();
        });
    }

    private void loadQuestion() {
        questionNumber.setText((currentQuestion + 1) + "/10");
        questionText.setText(questions[currentQuestion]);
    }
}
