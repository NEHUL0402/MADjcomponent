package com.example.madjcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SearchStudentActivity extends AppCompatActivity {

    private EditText etRegNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);

        // Initialize UI components
        etRegNo = findViewById(R.id.etRegNo);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnHome = findViewById(R.id.btnHome);

        // Set click listener for the Search button
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regNo = etRegNo.getText().toString().trim();
                if (!regNo.isEmpty()) {
                    // Perform search operation (for demonstration, we'll just show a Toast)
                    // In a real application, you would fetch student details from a database
                    Toast.makeText(SearchStudentActivity.this, "Searching for Student: " + regNo, Toast.LENGTH_SHORT).show();
                    // Here you can add logic to fetch and display student information based on regNo
                } else {
                    // Show a message if the registration number is empty
                    Toast.makeText(SearchStudentActivity.this, "Please enter a registration number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for the Home button
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the admin dashboard
                Intent intent = new Intent(SearchStudentActivity.this, AdminDashboardActivity.class);
                startActivity(intent);
                
            }
        });
    }
}
