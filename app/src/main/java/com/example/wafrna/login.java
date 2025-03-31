package com.example.wafrna;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        // Apply window insets to avoid system UI overlap
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Login button click listener
        Button login = findViewById(R.id.loginTo);
        login.setOnClickListener(v -> {
            Intent intent = new Intent(this, home_page.class);
            startActivity(intent);
        });

        // Forgot password click listener
        TextView forgetPassword = findViewById(R.id.forgot_password_text);
        forgetPassword.setOnClickListener(v -> {
            Intent intent = new Intent(this, RestartPasswordPage.class);
            startActivity(intent);
        });

        // Create account click listener
        TextView createAccount = findViewById(R.id.create_account_text);
        createAccount.setOnClickListener(v -> {
            Intent intent = new Intent(this, registery.class);
            startActivity(intent);
        });
    }
}
