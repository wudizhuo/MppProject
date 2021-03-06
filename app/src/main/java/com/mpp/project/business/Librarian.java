package com.mpp.project.business;

import java.util.Date;

/**
 * Created by prageeth on 3/7/17.
 */

public final class Librarian extends Person implements LibrarianRole {
    private IRole rolePlaying;

    public Librarian(int userId, String firstName, String lastName, String passWord, String phoneNo) {
        super(userId, firstName, lastName, passWord, phoneNo);
    }

    @Override
    public AuthorizationLevel getAuthorizationLevel() {
        return AuthorizationLevel.LIBRARIAN;
    }

//    @Override
//    public Book checkoutBook(LibraryMember member) {
//        return null;
//    }

    public void checkout(LibraryMember member, LendableCopy copy, Date checkoutDate, Date dueDate) {
        // Acess the CheckoutRecord
        // Check the book if its available or any copies of it available
        // Make a CheckoutRecordEntry

        //CheckoutRecordEntry entry = new CheckoutRecordEntry(book, copy, checkoutDate, dueDate);
        //member.getCheckoutRecord().addEntry(entry);
        //record.addEntry(entry);
    }


    @Override
    public void checkinBook(LibraryMember member) {

    }

    @Override
    public void setRole(IRole role) {
        rolePlaying = role;
    }

    @Override
    public IRole getRole() {
        return rolePlaying;
    }

    @Override
    public Book checkoutBook(LibraryMember member, LendableCopy copy, Date checkoutDate, Date dueDate) {
//        CheckoutRecordEntry entry = new CheckoutRecordEntry(copy, checkoutDate, dueDate);
//        member.getCheckoutRecord().addEntry(entry);
        return null;
    }


}
