package com.mpp.project.business;

import java.io.Serializable;
import java.util.Date;

public class LibraryMember extends Person implements Serializable {
	private CheckoutRecord record = new CheckoutRecord();

	public LibraryMember(int userId, String firstName, String lastName, String passWord, String phoneNo, Address address) {
		super(userId, firstName, lastName, passWord, phoneNo, address);
	}

	public void checkout(LendableCopy copy, Date checkoutDate, Date dueDate) {
		CheckoutRecordEntry entry = new CheckoutRecordEntry(copy, checkoutDate, dueDate);
		record.addEntry(entry);
		
	}
	
	public String toString() {
		return "Checkout record for library member " + super.getLastName() + ": " + record;
	}
	
	private static final long serialVersionUID = -2226197306790714013L;
	private String memberId;
}
