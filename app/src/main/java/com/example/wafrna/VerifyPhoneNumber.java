package com.example.wafrna;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class VerifyPhoneNumber extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verify_phone_number);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.verifyNumber), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button next = findViewById(R.id.next);
        next.setOnClickListener(v -> {
            // Navigate to login screen on logout
            Intent intent = new Intent(this, NewPasswordPage.class);
            startActivity(intent);
            finish(); // Close ProfilePage after logout if needed
        });
    }
}