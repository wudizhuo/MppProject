package com.mpp.project.business;

import java.util.Date;

/**
 * Created by prageeth on 3/7/17.
 */

public interface LibrarianRole extends IRole{
    Level level = Level.LIBRARIAN;
    public Book checkoutBook(LibraryMember member, LendableCopy copy, Date checkoutDate, Date dueDate);
    public void checkinBook(LibraryMember member);

}
