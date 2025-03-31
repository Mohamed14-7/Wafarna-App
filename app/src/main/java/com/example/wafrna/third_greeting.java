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

public class third_greeting extends ComponentActivity {

    @SuppressLint("MissingInflatedId")

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.third_greeting);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.third_greeting), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(v -> {
            Intent intent = new Intent(this, login.class);
            startActivity(intent);
            finish();
        });

        Button btn_regs = findViewById(R.id.btn_regs);

        btn_regs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(third_greeting.this, registery.class);
                startActivity(intent);
            }
        });

    }

}
