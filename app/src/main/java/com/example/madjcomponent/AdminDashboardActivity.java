package com.example.madjcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        // Get references to the buttons
        Button btnViewComplaints = findViewById(R.id.btnViewComplaints);
        Button btnViewProfile = findViewById(R.id.btnViewProfile);
        Button btnSearchStudent = findViewById(R.id.btnSearchStudent);
        Button btnHelp = findViewById(R.id.btnHelp);
        Button btnLogout = findViewById(R.id.btnLogout); // Reference to the Log Out button

        // Get username from intent
        username = getIntent().getStringExtra("USERNAME");

        // Set click listener for "View Complaints" button
        btnViewComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, ComplaintDetailsAdminActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for "View Profile" button
        btnViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, AdminProfileActivity.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            }
        });

        // Set click listener for "Help and Support" button
        btnSearchStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, SearchStudentActivity.class);
                startActivity(intent);
            }
        });






        // Set click listener for "Help and Support" button
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, HelpSupportActivity.class);
                startActivity(intent);
            }
        });






        // Set click listener for "Log Out" button
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK); // Clear activity stack
                startActivity(intent);
                finish(); // Finish this activity
            }
        });
    }
}
