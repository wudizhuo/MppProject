package com.mpp.project.business;

/**
 * Created by prageeth on 3/7/17.
 */

public final class Author extends Person {

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    private String shortBio;

    public Author(String firstName, String lastName, String phoneNo, Address address) {
        super(firstName, lastName, phoneNo, address);
    }

    public Author(String firstName, String lastName, String phoneNo, Address address, String description) {
        super(firstName, lastName, phoneNo, address);
        this.shortBio = description;
    }


}
