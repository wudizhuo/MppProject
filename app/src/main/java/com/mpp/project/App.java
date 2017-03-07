package com.mpp.project;

import android.app.Application;
import android.content.Context;

import com.mpp.project.business.Address;
import com.mpp.project.business.Admin;
import com.mpp.project.dataaccess.DataAccessFacade;

import java.io.File;

public class App extends Application {
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this.getApplicationContext();
        setupData();
    }

    private void setupData() {
        if (AppPreferences.getHasSetupFile()) {
            return;
        }
        DataAccessFacade dataAccessFacade = new DataAccessFacade();
        File appDir = dataAccessFacade.getDataDir();
        if (!appDir.exists()) {
            appDir.mkdirs();
        }

        Admin admin = new Admin(001, "firstName", "lastName", "password", "phoneNo", new Address());
        dataAccessFacade.savePerson(admin);

        AppPreferences.setHasSetupFile();
    }

    public static Context getContext() {
        return applicationContext;
    }
}
