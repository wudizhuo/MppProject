package com.mpp.project.business;

import java.io.Serializable;

public class Book extends Publication implements Serializable {
	private static int id;
	private String isbn;

	// TODO: Where do we keep the number of copies? NO In publication
	public Book(String isbn, String title) {
		super(title);
		this.isbn = isbn;
		id++; // Increase the ID of the instance of each book so this ID mataches the Lendable copyId
	}

	@Override
	public String toString() {
		return "id: " + id + ", isbn: " + isbn; /*+ ", available: " + available;*/
	}
}
