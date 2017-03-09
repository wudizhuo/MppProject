package com.mpp.project.controller;

import com.mpp.project.business.Author;
import com.mpp.project.business.Book;
import com.mpp.project.business.CheckoutRecordEntry;
import com.mpp.project.business.LendableCopy;
import com.mpp.project.business.LibraryMember;
import com.mpp.project.dataaccess.DataAccessFacade;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

public class BookController {
    private DataAccessFacade dataAccessFacade;

    public BookController() {
        dataAccessFacade = new DataAccessFacade();
    }

    public void addCopy(Book book) {
        book.addCopy();
        dataAccessFacade.saveBook(book);
    }

    public void checkout(Book book, LibraryMember member) {
        Date dueDate = new DateTime().plusDays(book.getMaximumCheckout()).toDate();
        LendableCopy lendableCopy = book.checkout();
        member.getCheckoutRecord().addEntry(new CheckoutRecordEntry(book, lendableCopy, new Date(), dueDate));
        dataAccessFacade.saveBook(book);
        dataAccessFacade.savePerson(member);
    }

    public Book queryBook(String isbn) {
        return dataAccessFacade.queryBook(isbn);
    }

    public void saveBook(String ISBN, String title, String maximumCheckout, String numberOfCopies, List<Author> authors) {

        com.mpp.project.business.Book book = new com.mpp.project.business.Book(ISBN, title, maximumCheckout, numberOfCopies, authors);
        dataAccessFacade.saveBook(book);
    }
}
