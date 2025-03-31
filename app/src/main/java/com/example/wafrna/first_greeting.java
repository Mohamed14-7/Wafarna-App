package com.example.wafrna;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class first_greeting extends ComponentActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.first_greeting);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.first_greeting), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn_fgreet = findViewById(R.id.btn_fgreet);

        btn_fgreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(first_greeting.this, second_greeting.class);
                startActivity(intent);
            }
        });

        Button skip = findViewById(R.id.skip);
        skipBtn(skip);
    }

    protected void skipBtn(Button btnBack) {
        if (btnBack != null) { // Prevent null pointer exception
            btnBack.setOnClickListener(v -> {
                Intent intent = new Intent(this, third_greeting.class);
                startActivity(intent);
            });
        }
    }
}
