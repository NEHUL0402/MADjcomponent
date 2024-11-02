package com.example.madjcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AdminProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);

        // Initialize UI components
        TextView tvAdminName = findViewById(R.id.tvAdminName);
        TextView tvAdminEmail = findViewById(R.id.tvAdminEmail);
        TextView tvAdminPhone = findViewById(R.id.tvAdminPhone);
        TextView tvAdminAddress = findViewById(R.id.tvAdminAddress);
        Button btnEditProfile = findViewById(R.id.btnEditProfile);

        // Get the admin data from Intent
        String username = getIntent().getStringExtra("USERNAME");
        String email = getIntent().getStringExtra("EMAIL");
        String phone = getIntent().getStringExtra("PHONE");
        String address = getIntent().getStringExtra("ADDRESS");

        // Set up profile information
        tvAdminName.setText(username != null ? username : "Admin Name");
        tvAdminEmail.setText(email != null ? email : "admin@example.com");
        tvAdminPhone.setText(phone != null ? phone : "Phone: +1234567890");
        tvAdminAddress.setText(address != null ? address : "Address: 123 Admin St, Admin City");

        // Set click listener for the Edit Profile button
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the EditProfileActivity
                Intent intent = new Intent(AdminProfileActivity.this, AdminDashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
