package com.mpp.project.business;

/**
 * Created by prageeth on 3/7/17.
 */

public final class Author extends Person {

    public Author(int userId, String firstName, String lastName, String passWord, String phoneNo, Address address) {
        super(userId, firstName, lastName, passWord, phoneNo, address);
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    private String shortBio;
}
