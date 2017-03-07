package com.mpp.project.business;

/**
 * Created by prageeth on 3/7/17.
 */

public final class Admin extends Person implements AdminRole {
    public Admin(String firstName, String lastName, String phoneNo, Address address) {
        super(firstName, lastName, phoneNo, address);
    }

    public Admin(String firstName, String lastName, String phoneNo, Address address, IRole role) {
        super(firstName, lastName, phoneNo, address);
        this.setRole(role);
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
