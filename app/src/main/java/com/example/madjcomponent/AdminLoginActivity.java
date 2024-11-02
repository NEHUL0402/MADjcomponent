package com.example.madjcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText etAdminUsername, etAdminPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        etAdminUsername = findViewById(R.id.etAdminUsername);
        etAdminPassword = findViewById(R.id.etAdminPassword);
        Button btnAdminLoginSubmit = findViewById(R.id.btnAdminLoginSubmit);

        btnAdminLoginSubmit.setOnClickListener(view -> {
            String username = etAdminUsername.getText().toString().trim();
            String password = etAdminPassword.getText().toString().trim();

            // Example check for login (replace with real authentication)
            if (username.equals("admin") && password.equals("password123")) {
                Toast.makeText(AdminLoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();


                // Redirect to admin dashboard or other activity here
                Intent intent = new Intent(AdminLoginActivity.this, AdminDashboardActivity.class);
                intent.putExtra("USERNAME", username);  // Add username to intent
                startActivity(intent);

            } else {
                Toast.makeText(AdminLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
