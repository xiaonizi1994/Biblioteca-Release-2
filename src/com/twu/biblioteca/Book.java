package com.twu.biblioteca;

public class Book {
	String Author;
	String Published;
	String name;
	String checkedName = "";
	boolean isCheckout = false;

	public Book(String name) {
		this.name = name;
	}

	public void bookInfo(String Author, String Published) {
		this.Author = Author;
		this.Published = Published;
	}

	public String detail() {
		// System.out.print(" Author:"+this.Author);
		// System.out.print(" Published:"+this.Published);
		return " Author:" + this.Author + " " + "Published:" + this.Published;
	}

	public void checkoutBook(Customer customer) {
		if (this.isCheckout == true) {
			failCheckout();
		} else {
			this.isCheckout = true;
			this.checkedName = customer.name;
			successCheckout();
		}
	}

	public void failCheckout() {
		System.out.println("That book is not available.");
	}

	public void successCheckout() {
		System.out.println("Thank you! Enjoy the book.");

	}

	public void successReturn() {
		// TODO Auto-generated method stub
		System.out.println("Thank you for returning the book.");
	}

	public void failReturn() {
		// TODO Auto-generated method stub
		System.out.println("That is not a valid book to return.");
	}

	public void returnBook(Customer customer) {
		if (this.checkedName == customer.name) {
			this.isCheckout = false;
			successReturn();
		} else {
			failReturn();
		}

	}

}
