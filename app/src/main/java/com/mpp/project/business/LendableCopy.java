package com.mpp.project.business;

import java.io.Serializable;

public class LendableCopy implements Serializable {
	private Publication publication;
	private int copyId;
	private boolean available;
	public void isAvailable(boolean b) {
		available = b;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}
	public String toString() {
		return publication.toString();
	}
	
}
