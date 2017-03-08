package com.mpp.project.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book extends Publication implements Serializable {
    private String isbn;
    private String maximumCheckout;
    private boolean availability;
    private List<LendableCopy> lendableCopies;

    public Book(String isbn, String title, String maximumCheckout, String numberOfCopies, List<Author> authorList) {
        super(title, authorList);
        this.isbn = isbn;
        this.maximumCheckout = maximumCheckout;
        lendableCopies = new ArrayList<>();
        setupLendableCopy(Integer.valueOf(numberOfCopies));
    }

    private void setupLendableCopy(int numberOfCopies) {
        for (int i = 0; i < numberOfCopies; i++) {
            addCopy();
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public int getMaximumCheckout() {
        return Integer.parseInt(maximumCheckout);
    }

    public boolean isAvailability() {
        return availability;
    }

    public String getNumberOfCopies() {
        return lendableCopies.size() + "";
    }

    public void addCopy() {
        lendableCopies.add(new LendableCopy(isbn + "000" + lendableCopies.size(), true));
        setAvailability(true);
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public LendableCopy checkout() {
        for (LendableCopy lendableCopy : lendableCopies) {
            if (lendableCopy.isAvailable()) {
                lendableCopy.setAvailable(false);
                return lendableCopy;
            }
        }
        setAvailability(false);
        return null;
    }
}
