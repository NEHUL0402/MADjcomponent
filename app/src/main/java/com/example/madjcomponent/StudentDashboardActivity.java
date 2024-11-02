package com.example.madjcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDashboardActivity extends AppCompatActivity {

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        // Retrieve the username from the Intent
        username = getIntent().getStringExtra("USERNAME");

        Button btnNewComplaint = findViewById(R.id.btnNewComplaint);
        Button btnViewComplaints = findViewById(R.id.btnViewComplaints);
        Button btnHelp = findViewById(R.id.btnHelp);
        Button btnLogout = findViewById(R.id.btnLogout); // Reference to the Log Out button

        // Redirect to SubmitComplaintActivity and pass the username
        btnNewComplaint.setOnClickListener(view -> {
            Intent intent = new Intent(StudentDashboardActivity.this, SubmitComplaintActivity.class);
            intent.putExtra("USERNAME", username);
            startActivity(intent);
        });

        // Redirect to ViewComplaintsActivity and pass the username
        btnViewComplaints.setOnClickListener(view -> {
            Intent intent = new Intent(StudentDashboardActivity.this, ViewComplaintsActivity.class);
            intent.putExtra("USERNAME", username);
            startActivity(intent);
        });

        // Redirect to HelpSupportActivity
        btnHelp.setOnClickListener(view -> {
            Intent intent = new Intent(StudentDashboardActivity.this, HelpSupportActivity.class);
            startActivity(intent);
        });

        // Set click listener for "Log Out" button
        btnLogout.setOnClickListener(view -> {
            Intent intent = new Intent(StudentDashboardActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK); // Clear activity stack
            startActivity(intent);
            finish(); // Finish this activity
        });
    }
}
