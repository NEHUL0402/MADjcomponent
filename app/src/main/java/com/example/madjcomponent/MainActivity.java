package com.example.madjcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button studentLoginButton = findViewById(R.id.btnStudentLogin);
        Button adminLoginButton = findViewById(R.id.btnAdminLogin);





        // Set an OnClickListener for the student login button
        studentLoginButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, StudentLoginActivity.class);
            startActivity(intent);
        });

        // Set an OnClickListener for the admin login button
        adminLoginButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AdminLoginActivity.class);
            startActivity(intent);
        });
    }
}
