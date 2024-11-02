package com.example.madjcomponent;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPreferencesManager {
    private static final String PREFS_NAME = "ComplaintPrefs";
    private final SharedPreferences sharedPreferences;
    private final Gson gson;

    public SharedPreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        gson = new Gson(); // Gson instance for JSON conversion
    }

    // Method to save complaint details
    public void saveComplaintDetails(Complaint complaint) {
        // Retrieve existing complaints
        List<Complaint> complaints = getComplaints();
        complaints.add(complaint); // Add the new complaint
        // Save back to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("complaints", gson.toJson(complaints));
        editor.apply(); // or editor.commit();
    }



    // Method to filter complaints by name
    public List<Complaint> filterComplaintsByName(String name) {
        List<Complaint> allComplaints = getComplaints();
        List<Complaint> filteredComplaints = new ArrayList<>();

        for (Complaint complaint : allComplaints) {
            if (complaint.getName().equalsIgnoreCase(name)) {
                filteredComplaints.add(complaint);
            }
        }

        return filteredComplaints;
    }






    // Method to retrieve all complaints
    public List<Complaint> getComplaints() {
        String json = sharedPreferences.getString("complaints", null);
        Type type = new TypeToken<List<Complaint>>() {}.getType();
        return json != null ? gson.fromJson(json, type) : new ArrayList<>();
    }

    // Method to display all complaints as a String
    public String displayAllComplaints() {
        List<Complaint> complaints = getComplaints();
        StringBuilder builder = new StringBuilder();
        for (Complaint complaint : complaints) {
            builder.append("Name: ").append(complaint.getName()).append("\n")
                    .append("Student ID: ").append(complaint.getStudentId()).append("\n")
                    .append("Email: ").append(complaint.getEmail()).append("\n")
                    .append("Phone: ").append(complaint.getPhone()).append("\n")
                    .append("Category: ").append(complaint.getCategory()).append("\n")
                    .append("Subject: ").append(complaint.getSubject()).append("\n")
                    .append("Description: ").append(complaint.getDescription()).append("\n")
                    .append("Location: ").append(complaint.getLocation()).append("\n")
                    .append("Anonymous: ").append(complaint.isAnonymous()).append("\n\n");
        }
        return builder.toString();
    }
}
