package com.mpp.project.controller;

import com.mpp.project.business.LibraryMember;
import com.mpp.project.dataaccess.DataAccessFacade;

public class PersonController {
    public LibraryMember getLibraryMember(int memberId) {
        DataAccessFacade dataAccessFacade = new DataAccessFacade();
        return (LibraryMember) dataAccessFacade.readPerson(memberId);
    }
}
