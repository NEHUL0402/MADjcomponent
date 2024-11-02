package com.example.madjcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SubmitComplaintActivity extends AppCompatActivity {

    private EditText editTextName, editTextStudentId, editTextEmail, editTextPhone;
    private EditText editTextSubject, editTextDescription, editTextLocation;
    private Spinner spinnerCategory;
    private CheckBox checkboxAnonymous;
    private SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_complaint);

        // Initialize fields
        editTextName = findViewById(R.id.editTextName);
        editTextStudentId = findViewById(R.id.editTextStudentId);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextSubject = findViewById(R.id.editTextSubject);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextLocation = findViewById(R.id.editTextLocation);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        checkboxAnonymous = findViewById(R.id.checkboxAnonymous);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        // Initialize SharedPreferencesManager
        sharedPreferencesManager = new SharedPreferencesManager(this);

        // Set up spinner options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.complaint_categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        // Handle form submission
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    submitForm();
                }
            }
        });
    }

    // Form validation method
    private boolean validateForm() {
        if (TextUtils.isEmpty(editTextName.getText())) {
            editTextName.setError("Please enter your name");
            return false;
        }
        if (TextUtils.isEmpty(editTextStudentId.getText())) {
            editTextStudentId.setError("Please enter your student ID");
            return false;
        }
        if (TextUtils.isEmpty(editTextEmail.getText())) {
            editTextEmail.setError("Please enter your email");
            return false;
        }
        if (TextUtils.isEmpty(editTextSubject.getText())) {
            editTextSubject.setError("Please enter a subject");
            return false;
        }
        if (TextUtils.isEmpty(editTextDescription.getText())) {
            editTextDescription.setError("Please enter a description");
            return false;
        }
        return true;
    }

    // Method to handle form submission
    private void submitForm() {
        String name = editTextName.getText().toString();
        String studentId = editTextStudentId.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();
        String category = spinnerCategory.getSelectedItem().toString();
        String subject = editTextSubject.getText().toString();
        String description = editTextDescription.getText().toString();
        String location = editTextLocation.getText().toString();
        boolean isAnonymous = checkboxAnonymous.isChecked();

        // Save the complaint details
        Complaint newComplaint = new Complaint(name, studentId, email, phone,
                category, subject, description,
                location, isAnonymous);
        sharedPreferencesManager.saveComplaintDetails(newComplaint);

        // Show a Toast message
        Toast.makeText(this, "Complaint Submitted", Toast.LENGTH_SHORT).show();

        // Pass data to the next activity
        Intent intent = new Intent(SubmitComplaintActivity.this, ComplaintDetailsActivity.class);

        // Put the complaint details in the intent extras
        intent.putExtra("name", name);
        intent.putExtra("studentId", studentId);
        intent.putExtra("email", email);
        intent.putExtra("phone", phone);
        intent.putExtra("category", category);
        intent.putExtra("subject", subject);
        intent.putExtra("description", description);
        intent.putExtra("location", location);
        intent.putExtra("isAnonymous", isAnonymous);


        // Start the next activity
        startActivity(intent);

        // Clear form after submission
        clearForm();
    }


    // Method to clear the form fields
    private void clearForm() {
        editTextName.setText("");
        editTextStudentId.setText("");
        editTextEmail.setText("");
        editTextPhone.setText("");
        editTextSubject.setText("");
        editTextDescription.setText("");
        editTextLocation.setText("");
        checkboxAnonymous.setChecked(false);
        spinnerCategory.setSelection(0);
    }
}
