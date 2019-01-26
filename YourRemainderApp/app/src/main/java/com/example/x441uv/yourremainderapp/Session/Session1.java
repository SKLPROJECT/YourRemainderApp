package com.example.x441uv.yourremainderapp.Session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.x441uv.yourremainderapp.BottomNavigationActivity;

import java.util.HashMap;

public class Session1 {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // Email address (make variable public to access from outside)
    public static final String KEY_NAMA = "Nama";
    public static final String KEY_ALAMAT = "Alamat";
    public static final String KEY_NOMORHP = "NomorHp";

    // Constructor
    public Session1(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     */
    public void createLoginSession(String Nama, String Alamat, String NomorHp) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing email in pref
        editor.putString(KEY_NAMA, Nama);
        editor.putString(KEY_ALAMAT, Alamat);
        editor.putString(KEY_NOMORHP, NomorHp);

        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If true it will redirect user to UserActivity Page
     * Else won't do anything
     */
    public void checkLogin() {
        // Check login status
        if (this.isLoggedIn()) {
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, BottomNavigationActivity.class);
            // Closing all the Activities
            i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP | i.FLAG_ACTIVITY_CLEAR_TASK | i.FLAG_ACTIVITY_NEW_TASK);

            // Staring Main Activity
            _context.startActivity(i);
        }

    }


    /**
     * Get stored session data
     */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();

        // user email id
        user.put(KEY_NAMA, pref.getString(KEY_NAMA, null));
        user.put(KEY_ALAMAT, pref.getString(KEY_ALAMAT, null));
        user.put(KEY_NOMORHP, pref.getString(KEY_NOMORHP, null));
        // return user
        return user;
    }

    /**
     * Clear session details
     */


    /**
     * Quick check for login
     **/
    // Get Login State
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
}
