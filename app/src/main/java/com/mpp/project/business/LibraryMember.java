package com.mpp.project.business;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {

	private static final long serialVersionUID = -2226197306790714013L;
	private String memberId;
	private CheckoutRecord checkoutRecord; // 1 to 1

	public LibraryMember(String firstName, String lastName, String passWord, String phoneNo, Address address) {
		super(firstName, lastName, passWord, phoneNo, address);
		setCheckoutRecord(new CheckoutRecord());
	}
//
//	public void checkout(LendableCopy copy, Date checkoutDate, Date dueDate) {
//		CheckoutRecordEntry entry = new CheckoutRecordEntry(copy, checkoutDate, dueDate);
//		checkoutRecord.addEntry(entry);
//
//	}
	
	public String toString() {
		return "Checkout checkoutRecord for library member " + super.getLastName() + ": " + getCheckoutRecord();
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}
}
