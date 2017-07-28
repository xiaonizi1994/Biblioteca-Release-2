package com.twu.biblioteca;

public class Librarian {
	Book[] books;
	Movie[] movies;
	Customer[] customers;

	public Librarian(Book[] books, Movie[] movies) {
		this.books = books;
		this.movies = movies;
	}

	public Librarian(Book[] books, Movie[] movies, Customer[] customer) {
		this.books = books;
		this.movies = movies;
		this.customers = customer;
	}

	public void listCustomer() {
		for (int i = 0; i < customers.length; i++) {
			System.out.println(i + 1 + ":name" + customers[i].name+" email:"+customers[i].email+" phoneNumber:"+customers[i].phoneNumber);
		}
	}

	public void listBooksForCustomer() {
		for (int i = 0; i < books.length; i++) {
			System.out.println(i + 1 + ":" + books[i].name + books[i].detail() + " isCheckOut:" + books[i].isCheckout);
		}
	}

	public void listBooksForLibaraian() {
		for (int i = 0; i < books.length; i++) {
			if (books[i].isCheckout == false) {
				System.out.println(i + 1 + ":" + books[i].name + " author:" + books[i].Author);
			}
		}
	}

	public void listMoviesForCustomer() {
		for (int i = 0; i < movies.length; i++) {
			System.out.println(i + 1 + "" + movies[i].detail() + " isCheckOut:" + movies[i].isCheckout.toString());
		}
	}

	public void checkOutDetail() {
		for (int i = 0; i < books.length; i++) {
			if(books[i].isCheckout==true){
				System.out.println(i + 1 + ":" + books[i].name + books[i].checkedName);
			}
			
		}
	}

}
