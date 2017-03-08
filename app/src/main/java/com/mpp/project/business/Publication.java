package com.mpp.project.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

abstract public class Publication implements Serializable {
	// TODO: How many copies? Same ISBN ? Same Author list? CompareTo
	private static final long serialVersionUID = 2010893663327964921L;
	private String title;
	private List<Author> authorList;

	public Publication(String title, List<Author> authorList) {
		this.authorList = authorList;
		this.title = title;
	}

	public Publication(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
}
