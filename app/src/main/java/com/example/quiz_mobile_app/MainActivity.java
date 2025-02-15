package com.example.quiz_mobile_app;

import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the logo container
        RelativeLayout logoContainer = findViewById(R.id.logoContainer);

        // Retrieve last translation position from SplashActivity
        int lastPosition = getIntent().getIntExtra("logo_position", -200);

        // Apply translation manually so logo stays at moved-up position
        if (logoContainer != null) {
            logoContainer.setTranslationY(lastPosition);
        }

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
