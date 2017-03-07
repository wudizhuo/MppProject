package com.mpp.project;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppPreferences {
    private static final String SETUP_FILE = "setupFile";
    public static SharedPreferences sPreferences;

    static {
        sPreferences = PreferenceManager.getDefaultSharedPreferences(App
                .getContext());
    }

    public static boolean getHasSetupFile() {
        return sPreferences.getBoolean(SETUP_FILE, false);
    }

    public static boolean setHasSetupFile() {
        return sPreferences.edit()
                .putBoolean(SETUP_FILE, true).commit();
    }

}
