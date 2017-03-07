package com.mpp.project.business;

/**
 * Created by prageeth on 3/7/17.
 */

public final class Admin extends Person implements AdminRole {
    public Admin(int userId, String firstName, String lastName, String passWord, String phoneNo, Address address) {
        super(userId, firstName, lastName, passWord, phoneNo, address);
    }

    @Override
    public void add(Object item) {

    }

    @Override
    public Object update(Object item) {
        return null;
    }

    @Override
    public void remove(Object item) {

    }

    @Override
    public void setRole(IRole role) {
        // Set the role which can be Librarian
    }

    @Override
    public IRole getRole() {
        // Return the role he is playing, if No Librarian return null
        return null;
    }
}
