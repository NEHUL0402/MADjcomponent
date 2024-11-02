package com.example.madjcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ComplaintDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_details);

        TextView textViewDetails = findViewById(R.id.textViewDetails);
        Button buttonHome = findViewById(R.id.buttonHome);

        // Retrieve complaint details from the Intent
        String name = getIntent().getStringExtra("name");
        String studentId = getIntent().getStringExtra("studentId");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        String category = getIntent().getStringExtra("category");
        String subject = getIntent().getStringExtra("subject");
        String description = getIntent().getStringExtra("description");
        String location = getIntent().getStringExtra("location");
        boolean isAnonymous = getIntent().getBooleanExtra("isAnonymous", false);

        // Display the details
        String details = "Name: " + name + "\n"
                + "Student ID: " + studentId + "\n"
                + "Email: " + email + "\n"
                + "Phone: " + phone + "\n"
                + "Category: " + category + "\n"
                + "Subject: " + subject + "\n"
                + "Description: " + description + "\n"
                + "Location: " + location + "\n"
                + "Anonymous: " + (isAnonymous ? "Yes" : "No");

        textViewDetails.setText(details);

        // Set click listener for the Home button
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the StudentDashboardActivity
                Intent intent = new Intent(ComplaintDetailsActivity.this, StudentDashboardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
