package com.example.quiz_mobile_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);  // Ensure activity_splash.xml exists in res/layout

        // Find the logo container (RelativeLayout)
        RelativeLayout logoContainer = findViewById(R.id.logoContainer);
        if (logoContainer == null) {
            throw new RuntimeException("Error: logoContainer not found in activity_splash.xml");
        }

        // Load animations
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        Animation moveUp = AnimationUtils.loadAnimation(this, R.anim.move_up);

        // Start animations
        logoContainer.startAnimation(fadeIn);
        logoContainer.startAnimation(zoomIn);
        logoContainer.startAnimation(moveUp);

        // Navigate to MainActivity after 3 seconds
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            intent.putExtra("logo_position", -200);  // Pass translation position
            startActivity(intent);
            finish(); // Close Splash Screen
        }, 3000);
    }
}
