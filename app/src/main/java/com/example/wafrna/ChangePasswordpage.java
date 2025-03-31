package com.example.wafrna;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChangePasswordpage extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // Ensure that EdgeToEdge is properly implemented
        setContentView(R.layout.activity_change_passwordpage);

        // Handle padding based on system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.changePassword), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Handle back button
        ImageView back = findViewById(R.id.backButton);
        back.setOnClickListener(v -> {
            finish();
        });
        // Handle next button
        Button next = findViewById(R.id.change);
        next.setOnClickListener(v -> {
            Dialog changeDialog = new Dialog(this);
            changeDialog.setContentView(R.layout.activity_change_password_success);

            if (changeDialog.getWindow() != null) {
                changeDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            }

            changeDialog.show();

            new Handler().postDelayed(() -> {
                changeDialog.dismiss();
                finish();
            }, 3000);
        });


    }


}
