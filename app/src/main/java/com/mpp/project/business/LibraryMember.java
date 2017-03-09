package com.mpp.project.business;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {

    private static final long serialVersionUID = -2226197306790714013L;
    private int memberId;
    private CheckoutRecord checkoutRecord; // 1 to 1

    @Override
    public AuthorizationLevel getAuthorizationLevel() {
        return null;
    }

    public LibraryMember(int memberId, String firstName, String lastName, String password, String phoneNo, Address address) {
        super(memberId, firstName, lastName, password, phoneNo, address);
        checkoutRecord = new CheckoutRecord();
    }

    @Override
    public String toString() {
        return super.getFirstName() + " " + super.getLastName();
    }

    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }

	public int getMemberId() {
		return memberId;
	}
    public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
        this.checkoutRecord = checkoutRecord;
    }
}
