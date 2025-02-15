package com.example.quiz_mobile_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    private TextView questionText, questionNumber;
    private RadioGroup optionsGroup;
    private Button nextButton, prevButton;

    private String[] questions;
    private String[][] options;
    private int[] answers;
    private int currentQuestion = 0;
    private int score = 0;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Fetch user name
        userName = getIntent().getStringExtra("USER_NAME");

        // Load questions and answers from strings.xml
        questions = getResources().getStringArray(R.array.quiz_questions);
        answers = getResources().getIntArray(R.array.correct_answers);

        // Load options dynamically from XML
        options = new String[questions.length][4];
        for (int i = 0; i < questions.length; i++) {
            int resId = getResources().getIdentifier("quiz_options_" + i, "array", getPackageName());
            options[i] = getResources().getStringArray(resId);
        }

        // Initialize UI components
        questionText = findViewById(R.id.questionText);
        questionNumber = findViewById(R.id.questionNumber);
        optionsGroup = findViewById(R.id.optionsGroup);
        nextButton = findViewById(R.id.nextButton);
        prevButton = findViewById(R.id.prevButton);

        loadQuestion();

        // Next button to move to next question
        nextButton.setOnClickListener(v -> {
            if (currentQuestion < questions.length - 1) {
                currentQuestion++;
                loadQuestion();
            } else {
                // Navigate to ResultActivity with score
//                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
//                intent.putExtra("USER_NAME", userName);
//                intent.putExtra("SCORE", score);
//                startActivity(intent);
                finish();
            }
        });

        // Previous button to move to previous question
        prevButton.setOnClickListener(v -> {
            if (currentQuestion > 0) {
                currentQuestion--;
                loadQuestion();
            }
        });

        // Handle option selection
        optionsGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedOption = findViewById(checkedId);
            if (selectedOption != null) {
                int selectedIndex = optionsGroup.indexOfChild(selectedOption);
                if (selectedIndex == answers[currentQuestion]) {
                    score++; // Increase score if correct
                }
            }
        });
    }

    private void loadQuestion() {
        // Update question number and text
        questionNumber.setText((currentQuestion + 1) + "/" + questions.length);
        questionText.setText(questions[currentQuestion]);

        // Clear previous selections
        optionsGroup.clearCheck();
        optionsGroup.removeAllViews();

        // Load options dynamically
        for (int i = 0; i < options[currentQuestion].length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(options[currentQuestion][i]);
            radioButton.setId(i);
            optionsGroup.addView(radioButton);
        }

        // Enable/Disable Previous button based on question index
        prevButton.setEnabled(currentQuestion > 0);
    }
}
