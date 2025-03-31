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

public class second_greeting extends ComponentActivity {

    @SuppressLint("MissingInflatedId")

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.second_greeting);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second_greeting), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button skip = findViewById(R.id.skip);
        skipBtn(skip);

        Button btn_sgreet = findViewById(R.id.next);

        btn_sgreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second_greeting.this, ActivityGreeting.class);
                startActivity(intent);
            }
        });
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
