package com.example.quiz_mobile_app;

<<<<<<< HEAD
import android.os.Bundle;
import android.widget.RelativeLayout;
=======
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
>>>>>>> 0328631 (splash + Homepage + draft of quiz)
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD
=======
    private EditText nameInput;
>>>>>>> 0328631 (splash + Homepage + draft of quiz)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        // Find the logo container
=======
        nameInput = findViewById(R.id.nameInput);
        Button startButton = findViewById(R.id.startButton);
>>>>>>> 0328631 (splash + Homepage + draft of quiz)
        RelativeLayout logoContainer = findViewById(R.id.logoContainer);

        // Retrieve last translation position from SplashActivity
        int lastPosition = getIntent().getIntExtra("logo_position", -200);

        // Apply translation manually so logo stays at moved-up position
        if (logoContainer != null) {
            logoContainer.setTranslationY(lastPosition);
        }

<<<<<<< HEAD
=======
        // Ensure EditText gets focus
        nameInput.requestFocus();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });

>>>>>>> 0328631 (splash + Homepage + draft of quiz)
        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
<<<<<<< HEAD
=======

    public void startQuiz() {
        String userName = nameInput.getText().toString().trim();

        if (!userName.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            intent.putExtra("USER_NAME", userName); // Pass user’s name
            startActivity(intent);
            finish(); // Close MainActivity
        } else {
            Toast.makeText(MainActivity.this, "Please enter your name!", Toast.LENGTH_SHORT).show();
            nameInput.requestFocus();
        }
    }
>>>>>>> 0328631 (splash + Homepage + draft of quiz)
}
