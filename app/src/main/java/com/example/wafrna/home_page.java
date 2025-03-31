package com.example.wafrna;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class home_page extends BaseActivity {

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize and set click listener for settings
        ImageView setting = findViewById(R.id.setting);
        setupSettingsButton(setting);

        // Category Click Listeners
        setCategoryClickListener(R.id.clothes);
        setCategoryClickListener(R.id.kitchen);
        setCategoryClickListener(R.id.furniture);
        setCategoryClickListener(R.id.others);

        setupHomeButton(R.id.nav_home);
        setupHomeButton(R.id.nav_home1);

        setupProfileButton(R.id.nav_profile);

    }

    private void setCategoryClickListener(int viewId) {
        RelativeLayout category = findViewById(viewId);
        category.setOnClickListener(v -> {
            Intent intent = new Intent(home_page.this, clothes.class);
            startActivity(intent);
        });

    }


}
