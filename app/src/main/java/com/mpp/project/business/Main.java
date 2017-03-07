package com.mpp.project.business;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
//import java.nio.file.FileSystems;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;

import com.mpp.project.dataaccess.DataAccess;
import com.mpp.project.dataaccess.DataAccessFacade;

public class Main {

	public static void main(String[] args) {
		LibraryMember member = new LibraryMember("John");
		Publication p = new Book(1, "1234","Gone with the Wind");
		LendableCopy c = new LendableCopy();
		c.setPublication(p);
		c.setCopyId(1);
		//member.checkout(c, LocalDate.now(), LocalDate.now().plus(30, ChronoUnit.DAYS));
		member.checkout(c, new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+2*24*60*60*1000));
		System.out.println("Location of 'user.dir':\n  "+DataAccessFacade.OUTPUT_DIR);
		DataAccess da = new DataAccessFacade();
		da.saveLibraryMember("Prageeth", member);
		System.out.println("Reading record for John:\n"+"  "+da.readLibraryMember("John"));
		

	}
	

}
