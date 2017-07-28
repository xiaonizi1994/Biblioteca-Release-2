package com.twu.biblioteca;

public class Movie {
	String name;
	String year;
	String director;
	String movieRating;
	Boolean isCheckout=false;
	String checkedName;
	public Movie(String name,String year,String director,String movieRating){
		this.name=name;
		this.year=year;
		this.director=director;
		this.movieRating=movieRating;
	}
	public String detail() {
		// System.out.print(" Author:"+this.Author);
		// System.out.print(" Published:"+this.Published);
		return " name:" + this.name + " " + "year:" +this.year + " " + "director:" + this.director + " " + "movie rating:" + this.movieRating;
	}
	public void checkoutMovie(Customer customer) {
		if (this.isCheckout == true) {
			failCheckout();
		} else {
			this.isCheckout = true;
			this.checkedName = customer.name;
			successCheckout();
		}
		
	}
	public void successCheckout() {
		System.out.println("Thank you! Enjoy the movie.");

		
	}
	public void failCheckout() {
		System.out.println("That movie is not available.");
		
	}
}
