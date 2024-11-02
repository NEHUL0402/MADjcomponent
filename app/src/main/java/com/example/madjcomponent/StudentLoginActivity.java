package com.example.madjcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentLoginActivity extends AppCompatActivity {

    private EditText etStudentUsername, etStudentPassword;
    private CredentialsManager credentialsManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        etStudentUsername = findViewById(R.id.etStudentUsername);
        etStudentPassword = findViewById(R.id.etStudentPassword);
        Button btnStudentLoginSubmit = findViewById(R.id.btnStudentLoginSubmit);



        // Initialize CredentialsManager
        credentialsManager = new CredentialsManager(this);




        btnStudentLoginSubmit.setOnClickListener(view -> {
            String username = etStudentUsername.getText().toString().trim();
            String password = etStudentPassword.getText().toString().trim();


            // Validate credentials
            if (credentialsManager.validateCredentials(username, password)) {

                Toast.makeText(StudentLoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                // Redirect to StudentDashboardActivity and pass the username
                Intent intent = new Intent(StudentLoginActivity.this, StudentDashboardActivity.class);
                intent.putExtra("USERNAME", username);  // Add username to intent
                startActivity(intent);

            } else {

                Toast.makeText(StudentLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
