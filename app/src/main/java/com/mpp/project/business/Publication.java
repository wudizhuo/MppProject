package com.mpp.project.business;

import java.io.Serializable;
import java.util.Date;

abstract public class Publication implements Serializable {
	
	private static final long serialVersionUID = 2010893663327964921L;
	private Date dateDue;
	private String title;
	protected void setDateDue(Date d) {
		dateDue = d;
	}
	public Publication(String title) {
		this.title = title;
	}
	public Date getDateDue() {
		return dateDue;
	}
	public String getTitle() {
		return title;
	}
}
