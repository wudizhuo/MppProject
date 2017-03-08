package com.mpp.project.business;

import java.io.Serializable;
import java.util.Date;

public class CheckoutRecordEntry implements Serializable {
    private Book book;
    private LendableCopy copy;
    private Date checkoutDate;
    private Date dueDate;

    public CheckoutRecordEntry(Book book, LendableCopy copy, Date checkoutDate, Date dueDate) {
        this.book = book;
        this.copy = copy;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public LendableCopy getCopy() {
        return copy;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
