package com.mpp.project.dataaccess;


import com.mpp.project.business.LibraryMember;

public interface DataAccess {
    public void saveLibraryMember(String name, LibraryMember member);

    public LibraryMember readLibraryMember(String name);
}
