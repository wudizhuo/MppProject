package com.mpp.project;

import android.app.Application;
import android.content.Context;

import com.mpp.project.business.Address;
import com.mpp.project.business.Admin;
import com.mpp.project.business.Author;
import com.mpp.project.business.Book;
import com.mpp.project.business.LibraryMember;
import com.mpp.project.dataaccess.DataAccessFacade;

import net.danlew.android.joda.JodaTimeAndroid;

import java.io.File;
import java.util.ArrayList;

public class App extends Application {
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this.getApplicationContext();
        setupData();
        JodaTimeAndroid.init(this);
    }

    private void setupData() {
//        if (AppPreferences.getHasSetupFile()) {
//            return;
//        }
        DataAccessFacade dataAccessFacade = new DataAccessFacade();
        File appDir = dataAccessFacade.getDataDir();
        if (!appDir.exists()) {
            appDir.mkdirs();
        }

        Admin admin = new Admin(001, "firstName", "lastName", "password", "phoneNo");
        dataAccessFacade.savePerson(admin);

        LibraryMember member = new LibraryMember(100, "LibraryMember-firstName", "LibraryMember-lastName", "password", "123", new Address("street", "city", "state", "zip"));
        dataAccessFacade.savePerson(member);

        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("firstName", "lastName", "phoneNo", new Address("street", "city", "state", "zip"), "credentials", "bio"));
        Book book = new Book("1001", "MPP-C++", "7", "5", authors);
        Book book2 = new Book("1002", "MPP-C++", "7", "5", authors);

        dataAccessFacade.saveBook(book);
        dataAccessFacade.saveBook(book2);

        AppPreferences.setHasSetupFile();
    }

    public static Context getContext() {
        return applicationContext;
    }
}
