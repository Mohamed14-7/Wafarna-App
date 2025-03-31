package com.example.wafrna;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class clothes extends BaseActivity {

    private static final String TAG = "ClothesActivity";  // Tag for debugging

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.clothes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.choose), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup UI elements
        ImageView setting = findViewById(R.id.setting);
        setupSettingsButton(setting);
        setupHomeButton(R.id.nav_home1);
        setupProfileButton(R.id.nav_profile);

        Button btnBack = findViewById(R.id.btnBack);
        backButtonAction(btnBack);

        // Setup click listeners for multiple layouts
        setupDescriptionButton(R.id.details1);
        setupDescriptionButton(R.id.details2);
        setupDescriptionButton(R.id.details3);
    }

    private void setupDescriptionButton(int layoutId) {
        Button descriptionButton = findViewById(layoutId);
        if (descriptionButton != null) {
            descriptionButton.setOnClickListener(v -> {
                Intent intent = new Intent(this, description.class);
                startActivity(intent);
            });
        }
    }
}
