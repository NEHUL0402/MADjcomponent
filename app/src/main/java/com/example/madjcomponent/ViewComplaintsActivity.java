package com.example.madjcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ViewComplaintsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);

        // Retrieve the username from the Intent
        String username = getIntent().getStringExtra("USERNAME");

        // Initialize SharedPreferencesManager with the correct context
        SharedPreferencesManager prefsManager = new SharedPreferencesManager(this); // Use 'this' for context

        // Filter complaints by the username
        List<Complaint> filtered = prefsManager.filterComplaintsByName(username); // Use the retrieved username

        // Prepare to display the complaints
        TextView tvWelcome = findViewById(R.id.tvWelcomeUser);
        TextView tvComplaintsList = findViewById(R.id.tvComplaintsList); // Assuming you have another TextView to display the complaints

        Button buttonHome = findViewById(R.id.buttonHome);
        // Set button functionality to return to admin dashboard
        buttonHome.setOnClickListener(v -> {
            Intent intent = new Intent(ViewComplaintsActivity.this, StudentDashboardActivity.class);
            intent.putExtra("USERNAME", username);
            startActivity(intent);
        });
        // Display the username
        tvWelcome.setText("Welcome, " + username);

        // Format the filtered complaints into a string
        StringBuilder complaintsDisplay = new StringBuilder();
        for (Complaint complaint : filtered) {
            complaintsDisplay.append("Name: ").append(complaint.getName()).append("\n")
                    .append("Student ID: ").append(complaint.getStudentId()).append("\n")
                    .append("Email: ").append(complaint.getEmail()).append("\n")
                    .append("Phone: ").append(complaint.getPhone()).append("\n")
                    .append("Category: ").append(complaint.getCategory()).append("\n")
                    .append("Subject: ").append(complaint.getSubject()).append("\n")
                    .append("Description: ").append(complaint.getDescription()).append("\n")
                    .append("Location: ").append(complaint.getLocation()).append("\n")
                    .append("Anonymous: ").append(complaint.isAnonymous()).append("\n\n");
        }

        // Set the complaints display text
        tvComplaintsList.setText(complaintsDisplay.toString());
    }
}
