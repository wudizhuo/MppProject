package com.mpp.project.dataaccess;

import com.mpp.project.business.LibraryMember;

import java.io.File;


public class DataAccessFacade implements DataAccess {
    public void saveLibraryMember(String name, LibraryMember member) {
        FileStorageUtil.writeObject(new File(name), member);
    }

    public LibraryMember readLibraryMember(String name) {
        return (LibraryMember) FileStorageUtil.readObject(new File(name));
    }

}
