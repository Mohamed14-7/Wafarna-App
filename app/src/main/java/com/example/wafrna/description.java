package com.example.wafrna;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class description extends BaseActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.description);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.description), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView setting = findViewById(R.id.setting);
        setupSettingsButton(setting);
        setupHomeButton(R.id.nav_home1);

        Button btnBack = findViewById(R.id.btnBack);
        backButtonAction(btnBack);

        setupProfileButton(R.id.nav_profile);

    }
}