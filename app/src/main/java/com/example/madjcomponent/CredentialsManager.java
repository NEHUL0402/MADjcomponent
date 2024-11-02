package com.example.madjcomponent;

import android.content.Context;
import android.content.SharedPreferences;

public class CredentialsManager {
    private static final String PREFS_NAME = "UserPrefs";
    private static final String KEY_USERNAME_PREFIX = "username_";
    private static final String KEY_PASSWORD_PREFIX = "password_";
    private final SharedPreferences sharedPreferences;

    public CredentialsManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
        initializeDefaultCredentials();

    }
    // Initialize default credentials if they don't exist
    public void initializeDefaultCredentials() {
        if (sharedPreferences.getString(KEY_PASSWORD_PREFIX + "alice", null) == null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_USERNAME_PREFIX + "alice", "alice");
            editor.putString(KEY_PASSWORD_PREFIX + "alice", "password123");
            editor.putString(KEY_USERNAME_PREFIX + "bob", "bob");
            editor.putString(KEY_PASSWORD_PREFIX + "bob", "password456");
            editor.putString(KEY_USERNAME_PREFIX + "charlie", "charlie");
            editor.putString(KEY_PASSWORD_PREFIX + "charlie", "password789");
            editor.apply();
        }
    }


    // Save username and password
    public void saveCredentials(String username, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME_PREFIX + username, username);
        editor.putString(KEY_PASSWORD_PREFIX + username, password);
        editor.apply(); // or editor.commit();
    }

    public boolean validateCredentials(String username, String password) {
        String storedPassword = sharedPreferences.getString(KEY_PASSWORD_PREFIX + username, null);
        System.out.println("Stored password for " + username + ": " + storedPassword); // Debug line

        return storedPassword != null && storedPassword.equals(password);
    }

}
