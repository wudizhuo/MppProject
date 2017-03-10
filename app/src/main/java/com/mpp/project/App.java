package com.mpp.project;

import android.app.Application;
import android.content.Context;

import com.mpp.project.business.Address;
import com.mpp.project.business.Admin;
import com.mpp.project.business.Author;
import com.mpp.project.business.Book;
import com.mpp.project.business.Librarian;
import com.mpp.project.business.LibraryMember;
import com.mpp.project.business.SuperAdmin;
import com.mpp.project.controller.BookController;
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

        SuperAdmin superAdmin = new SuperAdmin(001, "super", "Admin", "password", "phoneNo");
        dataAccessFacade.savePerson(superAdmin);
        Admin admin = new Admin(002, "firstName", "lastName", "password", "phoneNo");
        dataAccessFacade.savePerson(admin);

        Librarian librarian = new Librarian(003, "firstName", "lastName", "password", "phoneNo");
        dataAccessFacade.savePerson(librarian);


        // TODO:A librarian has to checkout a book? So we need a librarian. If we use UserInfoMgr.getInstance().getUser(), we have to upcast it?
        // So i extended the Admin, not Person in the SuperAdmin class so had to make Admin not final.
        LibraryMember member = new LibraryMember(100, "LibraryMember's firstName", "LibraryMember-lastName", "password", "123", new Address("street", "city", "state", "zip", "country"));
        LibraryMember member2 = new LibraryMember(101, "LibraryMember's firstName", "LibraryMember-lastName", "password", "123", new Address("street", "city", "state", "zip", "country"));
        LibraryMember member3 = new LibraryMember(102, "LibraryMember's firstName", "LibraryMember-lastName", "password", "123", new Address("street", "city", "state", "zip", "country"));
        LibraryMember member4 = new LibraryMember(104, "LibraryMember's firstName", "LibraryMember-lastName", "password", "123", new Address("street", "city", "state", "zip", "country"));
        dataAccessFacade.savePerson(member);
        dataAccessFacade.savePerson(member2);
        dataAccessFacade.savePerson(member3);
        dataAccessFacade.savePerson(member4);

        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("firstName", "lastName", "phoneNo", new Address("street", "city", "state", "zip", "country"), "credentials", "bio"));
        Book book = new Book("1001", "MPP-C++", "7", "5", authors);
        book.addCopy();
        book.addCopy();
        book.addCopy();
        Book book2 = new Book("1002", "MPP-C++", "7", "5", authors);
        book2.addCopy();
        book2.addCopy();
        book2.addCopy();
        Book book3 = new Book("1003", "MPP-C++", "7", "5", authors);
        book3.addCopy();
        Book book4 = new Book("1004", "MPP-C++", "7", "5", authors);
        book4.addCopy();

        dataAccessFacade.saveBook(book);
        dataAccessFacade.saveBook(book2);
        dataAccessFacade.saveBook(book3);
        dataAccessFacade.saveBook(book4);

        BookController bookController = new BookController();
        bookController.checkout(book, member);
        bookController.checkout(book2, member2);
        bookController.checkout(book3, member3);
        bookController.checkout(book4, member4);


        AppPreferences.setHasSetupFile();
    }

    public static Context getContext() {
        return applicationContext;
    }
}
