package com.mpp.project.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

abstract public class Publication implements Serializable {
	// TODO: How many copies? Same ISBN ? Same Author list? CompareTo
	private static final long serialVersionUID = 2010893663327964921L;
	private Date dateDue;
	private String title;
	private List<Author> authorList;

	public Publication(String title, Date dateDue, List<Author> authorList) {
		this.authorList = authorList;
		this.dateDue = dateDue;
		this.title = title;
	}

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
