package com.mpp.project.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Book extends Publication implements Serializable {
    private String isbn;
    private int numberOfCopies;
    private List<LendableCopy> lendableCopies;

    public Book(String isbn, String title, int numberOfCopies, Date dateDue, List<Author> authorList) {
        super(title, dateDue, authorList);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
