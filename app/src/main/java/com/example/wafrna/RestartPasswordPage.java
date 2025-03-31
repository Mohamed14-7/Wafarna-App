package com.example.wafrna;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.wafrna.R;


public class RestartPasswordPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_restart_password);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.restartPassword), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(v -> {
            // Navigate to login screen on logout
            Intent intent = new Intent(this, VerifyPhoneNumber.class);
            startActivity(intent);
            finish(); // Close ProfilePage after logout if needed
        });
    }


}