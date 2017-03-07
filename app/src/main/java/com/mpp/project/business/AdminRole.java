package com.mpp.project.business;


/**
 * Created by prageeth on 3/7/17.
 */

public interface AdminRole extends IRole{
    Level level = Level.ADMIN;
//    public void addLibraryMember(LibraryMember libraryMember);
//    public LibraryMember updateLibraryMember(LibraryMember libraryMember);
//    public void removeLibraryMember(LibraryMember libraryMember);
    // Not specific since admin role should be able to handle anything inside the sytem
    public void add(Object item);
    public Object update(Object item);
    public void remove(Object item);

}
