package com.example.wafrna;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfilePage extends BaseActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_page);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the LinearLayout by ID
        LinearLayout chgPassSuccess = findViewById(R.id.chgPass);

        if (chgPassSuccess != null) { // Prevent NullPointerException
            chgPassSuccess.setOnClickListener(v -> {
                Intent intent = new Intent(this, ChangePasswordpage.class);
                startActivity(intent);
                finish(); // Optional: Remove this if you want back button support
            });
        }


        ImageView btnBack = findViewById(R.id.btnBack);
        backButtonAction(btnBack);

        Button logout = findViewById(R.id.logoutButton);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(ProfilePage.this, login.class);
            startActivity(intent);
            finish();
        });
    }
    protected void backButtonAction(ImageView imgView) {
        imgView.setOnClickListener(v -> finish());
    }
}
