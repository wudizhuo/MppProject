package com.mpp.project.business;

/**
 * Created by prageeth on 3/7/17.
 */

public interface LibrarianRole extends IRole{
    Level level = Level.LIBRARIAN;
    public Book checkoutBook(LibraryMember member);
    public void checkinBook(LibraryMember member);

}
