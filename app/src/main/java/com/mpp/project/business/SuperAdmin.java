package com.mpp.project.business;

/**
 * Created by prageeth on 3/7/17.
 */

public final class SuperAdmin extends Person {

    public SuperAdmin(int userId, String firstName, String lastName, String passWord, String phoneNo) {
        super(userId, firstName, lastName, passWord, phoneNo);
    }

    @Override
    public AuthorizationLevel getAuthorizationLevel() {
        return AuthorizationLevel.BOTH;
    }
}

