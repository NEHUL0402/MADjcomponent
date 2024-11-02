package com.example.madjcomponent;

public class Complaint {
    private String name;
    private String studentId;
    private String email;
    private String phone;
    private String category;
    private String subject;
    private String description;
    private String location;
    private boolean isAnonymous;

    // Constructor
    public Complaint(String name, String studentId, String email, String phone,
                     String category, String subject, String description,
                     String location, boolean isAnonymous) {
        this.name = name;
        this.studentId = studentId;
        this.email = email;
        this.phone = phone;
        this.category = category;
        this.subject = subject;
        this.description = description;
        this.location = location;
        this.isAnonymous = isAnonymous;
    }

    // Getters
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCategory() { return category; }
    public String getSubject() { return subject; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public boolean isAnonymous() { return isAnonymous; }
}
