package com.dieam.reactnativepushnotification.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import java.util.Arrays;

public class UserSession {
    private final String token = "token";



    private SharedPreferences sp;
    private SharedPreferences.Editor spEditor;
    private Context mContext;

    public UserSession(Context context) {
        if (context != null) {
            sp = PreferenceManager.getDefaultSharedPreferences(context);
            this.mContext = context;
        }
    }


    private static UserSession instance;

    public static UserSession getInstance(Context context) {

        if (instance == null) {
            instance = new UserSession(context);
        }
        return instance;
    }





    public String getToken() {
        return sp.getString(token, "");
    }


    public boolean setToken(String status) {
        spEditor = sp.edit();
        spEditor.putString(token, status);
        spEditor.apply();
        return true;
    }





}
