package com.mpp.project.business;

/**
 * Created by prageeth on 3/7/17.
 */

public final class Author extends Person {
    private String credentials;
    private String shortBio;
    private String authorId;

    public Author(String firstName, String lastName, String phoneNo, Address address, String credentials, String shortBio) {
        super(firstName, lastName, phoneNo, address);
        this.credentials = credentials;
        this.shortBio = shortBio;
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
