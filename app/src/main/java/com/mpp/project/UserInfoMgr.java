package com.mpp.project;


import com.mpp.project.business.Person;

public final class UserInfoMgr {
    private static UserInfoMgr mInstance;
    private Person user;

    private UserInfoMgr() {
    }

    public static UserInfoMgr getInstance() {
        if (mInstance == null) {
            mInstance = new UserInfoMgr();
        }
        return mInstance;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

}
