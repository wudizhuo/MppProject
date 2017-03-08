package com.mpp.project.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Book extends Publication implements Serializable {
    private String isbn;
    private String maximumCheckout;
    private String numberOfCopies;
    private boolean availability;
    private List<LendableCopy> lendableCopies;

    public Book(String isbn, String title, String maximumCheckout, String numberOfCopies, Date dateDue, List<Author> authorList) {
        super(title, dateDue, authorList);
        this.isbn = isbn;
        this.maximumCheckout = maximumCheckout;
        this.numberOfCopies = numberOfCopies;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getMaximumCheckout() {
        return maximumCheckout;
    }

    public boolean isAvailability() {
        return availability;
    }

    public String getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(String numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}
