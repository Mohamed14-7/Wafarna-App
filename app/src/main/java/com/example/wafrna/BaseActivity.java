package com.example.wafrna;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;

public class BaseActivity extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Sets up the settings button to open the settings dialog.
     *
     * @param settingButton The ImageView instance to attach the click listener.
     */
    protected void setupSettingsButton(ImageView settingButton) {
        settingButton.setOnClickListener(v -> showSettingsDialog());
    }

    protected void setupHomeButton(int navHomeId) {
        LinearLayout navHome = findViewById(navHomeId);

        if (navHome != null) { // Prevent null pointer exception
            navHome.setOnClickListener(v -> {
                Intent intent = new Intent(this, home_page.class);
                startActivity(intent);
            });
        }
    }

    protected void setupProfileButton(int profileButtonId) {
        LinearLayout profile = findViewById(profileButtonId);
        if (profile != null) {
            profile.setOnClickListener(v -> {
                Intent intent = new Intent(this, ProfilePage.class);
                startActivity(intent);
            });
        }
    }


    /**
     * Sets up a back button to navigate to the previous screen.
     *
     * @param btnBack The Button instance to attach the click listener.
     */
    protected void backButtonAction(@NonNull Button btnBack) {
        btnBack.setOnClickListener(v -> finish()); // Go back to the previous screen
    }

    /**
     * Displays the settings dialog.
     */
    protected void showSettingsDialog() {
        Dialog settingsDialog = new Dialog(this);
        settingsDialog.setContentView(R.layout.settings_overlay);

        if (settingsDialog.getWindow() != null) {
            settingsDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        Button closeButton = settingsDialog.findViewById(R.id.close_button);
        Button logoutButton = settingsDialog.findViewById(R.id.logout_button);
        Button notificationsButton = settingsDialog.findViewById(R.id.notifications_button);
        Button waittingOrders =  settingsDialog.findViewById(R.id.waiting_orders);
        // Close button action
        closeButton.setOnClickListener(v -> settingsDialog.dismiss());

        // Logout button action
        logoutButton.setOnClickListener(v -> {
            settingsDialog.dismiss();
            Intent intent = new Intent(this, login.class);
            startActivity(intent);
            finish();
        });

        // Notifications button action (navigate to NotificationActivity)
        notificationsButton.setOnClickListener(v -> {
            settingsDialog.dismiss();
            Intent intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);
        });

        waittingOrders.setOnClickListener(v -> {
            settingsDialog.dismiss();
            Intent intent = new Intent(this, WatingListPage.class);
            startActivity(intent);
        });



        settingsDialog.show();
    }
}
