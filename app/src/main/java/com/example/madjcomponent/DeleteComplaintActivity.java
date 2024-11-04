package com.example.madjcomponent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteComplaintActivity extends AppCompatActivity {

    private EditText editTextStudentId;
    private SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_complaint);

        // Initialize views
        editTextStudentId = findViewById(R.id.editTextStudentId);
        Button buttonDelete = findViewById(R.id.buttonDelete);

        // Initialize SharedPreferencesManager
        sharedPreferencesManager = new SharedPreferencesManager(this);

        // Set onClickListener for the delete button
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentId = editTextStudentId.getText().toString().trim();

                // Validate input
                if (studentId.isEmpty()) {
                    Toast.makeText(DeleteComplaintActivity.this, "Please enter a Student ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Attempt to delete the complaint
                boolean isDeleted = sharedPreferencesManager.deleteComplaintByStudentId(studentId);
                if (isDeleted) {
                    Toast.makeText(DeleteComplaintActivity.this, "Complaint(s) deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DeleteComplaintActivity.this, "No complaints found for the provided Student ID", Toast.LENGTH_SHORT).show();
                }

                // Clear the input field after processing
                editTextStudentId.setText("");
            }
        });
    }
}
