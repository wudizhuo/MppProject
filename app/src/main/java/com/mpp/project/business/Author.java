package com.mpp.project.business;

/**
 * Created by prageeth on 3/7/17.
 */

public final class Author extends Person {

    private String shortBio;
    private String authorId;

    public Author(int userId, String firstName, String lastName, String passWord, String phoneNo, Address address) {
        super(firstName, lastName, passWord, phoneNo, address);
        this.authorId = "AU"+getUserId();

    }

    public String getShortBio() {
        return shortBio;
    }

    public String getAuthorId() {
        return authorId;
    }
    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

}
