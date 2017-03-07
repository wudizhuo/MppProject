package com.mpp.project.business;

import java.io.Serializable;
import java.util.Date;

import com.mpp.project.dataaccess.DataAccessFacade;

public class CheckoutRecordEntry implements Serializable {
	private LendableCopy copy;
	private Date checkoutDate;
	private Date dueDate;
	public CheckoutRecordEntry(LendableCopy copy, Date checkoutDate, Date dueDate){
		this.copy = copy;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
	public String toString() {
//		return "[" + "checkoutdate:" +
//	        checkoutDate.format(DateTimeFormatter.ofPattern(DataAccessFacade.DATE_PATTERN)) +
//	        ", dueDate: " + dueDate.format(DateTimeFormatter.ofPattern(DataAccessFacade.DATE_PATTERN)) +
//	        ", publication: " + copy + "]";
		return "checkoutdate"+checkoutDate;
	}
}
