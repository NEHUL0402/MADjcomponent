package com.example.madjcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ComplaintDetailsAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_admin_details); // Fixed reference here

        // Initialize the SharedPreferencesManager
        SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(this);

        // Find the TextView and Button in the layout
        TextView textViewComplaintDetails = findViewById(R.id.textViewComplaint);
        Button buttonHome = findViewById(R.id.buttonHome);

        // Retrieve and display all complaints
        String allComplaints = sharedPreferencesManager.displayAllComplaints();
        textViewComplaintDetails.setText(allComplaints);

        // Set button functionality to return to admin dashboard
        buttonHome.setOnClickListener(v -> {
            Intent intent = new Intent(ComplaintDetailsAdminActivity.this, AdminDashboardActivity.class);
            startActivity(intent);
        });
    }
}
