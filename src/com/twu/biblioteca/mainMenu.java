package com.twu.biblioteca;

import java.util.Scanner;

public class mainMenu {
	public void mainMenuShow() {
		chooseRoleMenu();
	}

	public void chooseRoleMenu() {
		Librarian librarian = librarianInit();
		System.out.println("please choose what your role ");
		System.out.println("1.librarian ");
		System.out.println("2.customer ");
		System.out.println("3.Quit");
		Scanner scan = new Scanner(System.in);
		int roleChoose = scan.nextInt();
		if (roleChoose == 1) {
			chooseActionMenuForLibarian(librarian);
			// menuChooseBook(books, librarian);
		} else if (roleChoose == 2) {
			loginMenu(librarian);
		} else if (roleChoose == 3) {
			Quit();
		} else {
			InvalidMenuOption();
			chooseRoleMenu();
		}
	}

	private Librarian librarianInit() {
		Book bookHongloumeng = new Book("xiyouji");
		bookHongloumeng.bookInfo("caoxueqing", "2005");
		Book bookXiyouji = new Book("hongloumeng");
		bookXiyouji.bookInfo("wuchengen", "2008");
		Book bookSanti = new Book("Santi");
		bookSanti.bookInfo("liucixing", "2016");
		bookSanti.isCheckout = true;
		bookSanti.checkedName="Angela";
		Book[] books = { bookXiyouji, bookHongloumeng, bookSanti };
		Movie movie1 = new Movie("Blackbird", "2014", "Gina Prince-Bythewood", "G");
		Movie movie2 = new Movie("Story of Your Life", " 2016", "Denis Villeneuve", "G");
		Movie[] movies = { movie1, movie2 };
		Customer customer1 = new Customer("lily", "1111-1111", "123", "123@qq.com", "1871254848");
		Customer customer2 = new Customer("june", "2222-2222", "123", "234@qq.com", "1871234848");
		Customer[] customers = { customer1, customer2 };
		Librarian librarian = new Librarian(books, movies, customers);
		return librarian;
	}

	public int loginMenu(Librarian librarian) {
		System.out.println("please input your id:(1111-1111)");
		Scanner scan1 = new Scanner(System.in);
		String id = scan1.next();
		System.out.println("please input your password:(123)");
		Scanner scan2 = new Scanner(System.in);
		String password = scan2.next();
		for (int i = 0; i < librarian.customers.length; i++) {
			if (librarian.customers[i].id.equals(id) && librarian.customers[i].password.equals(password)) {
				System.out.println("Hi," + librarian.customers[i].name);
				chooseActionMenuForCustomer(librarian,librarian.customers[i]);
				return 0;
			}
		}
		System.out.println("please input right id or password");
		return 0;
	}

	private void chooseActionMenuForCustomer(Librarian librarian,Customer customer) {
		System.out.println("1.List Books ");
		System.out.println("2.List Movies");
		System.out.println("3.User Account");
		System.out.println("4.Quit ");
		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
		if (choose == 1) {
			librarian.listBooksForCustomer();
			menuChooseBook(librarian,customer);
		} else if (choose == 2) {
			librarian.listMoviesForCustomer();
			menuChooseMovie(librarian,customer);
		} else if (choose == 3) {
			customer.customerDetail();
		} else if (choose == 4) {
			Quit();
		} else {
			InvalidMenuOption();
			chooseActionMenuForCustomer(librarian,customer);
		}

	}

	private void menuChooseBook(Librarian librarian,Customer customer) {
		System.out.println("please choose the book:");
		Scanner scan = new Scanner(System.in);
		int chooseBook = scan.nextInt();
		if (chooseBook > 0 && chooseBook <= librarian.books.length) {
			System.out.println(librarian.books[chooseBook - 1].name);
			chooseBookOperate(librarian.books[chooseBook - 1],customer);
		} else {
			InvalidMenuOption();
			menuChooseBook(librarian,customer);
		}
	}

	private void menuChooseMovie(Librarian librarian,Customer customer) {
		System.out.println("please choose the Movie:");
		Scanner scan = new Scanner(System.in);
		int chooseMovie = scan.nextInt();
		if (chooseMovie > 0 && chooseMovie <= librarian.books.length) {
			System.out.println(librarian.movies[chooseMovie - 1].name);
			chooseMovieOperate(librarian.movies[chooseMovie - 1],customer);
		} else {
			InvalidMenuOption();
			menuChooseMovie(librarian,customer);
		}

	}

	private void chooseBookOperate(Book book,Customer customer) {
		System.out.println("please choose what your operate to this book: ");
		System.out.println("1.Checkout Book");
		System.out.println("2.Return Book");
		System.out.println("3.Quit ");
		Scanner scan = new Scanner(System.in);
		int chooseOperate = scan.nextInt();
		if (chooseOperate == 1) {
			book.checkoutBook(customer);
		} else if (chooseOperate == 2) {
			book.returnBook(customer);
		}
	}

	private void chooseMovieOperate(Movie movie,Customer customer) {
		System.out.println("please choose what your operate to this movie: ");
		System.out.println("1.Checkout movie");
		System.out.println("2.Quit ");
		Scanner scan = new Scanner(System.in);
		int chooseOperate = scan.nextInt();
		if (chooseOperate == 1) {
			movie.checkoutMovie(customer);
		} else if (chooseOperate == 2) {
			Quit();
		} else {
			InvalidMenuOption();
			chooseMovieOperate(movie,customer);
		}
	}

	private void chooseActionMenuForLibarian(Librarian librarian) {
		System.out.println("1.List Books ");
		System.out.println("2.Show Customers");
		System.out.println("3.Checkout Detail");
		System.out.println("4.Quit ");
		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
		if (choose == 1) {
			librarian.listBooksForLibaraian();
		} else if (choose == 2) {
			librarian.listCustomer();
		}else if (choose == 3) {
			librarian.checkOutDetail();
		} else if (choose == 4) {
			Quit();
		} else {
			InvalidMenuOption();
			chooseActionMenuForLibarian(librarian);
		}

	}

	// public void listBooksMenu(Librarian librarian) {
	// System.out.println("please choose what your role ");
	// System.out.println("1.librarian ");
	// System.out.println("2.customer ");
	// System.out.println("3.Quit");
	// Scanner scan = new Scanner(System.in);
	// int roleChoose = scan.nextInt();
	// if (roleChoose == 1) {
	// librarian.listBooksForLibaraian();
	// } else if (roleChoose == 2) {
	// librarian.listBooksForCustomer();
	// menuChooseBook(librarian);
	// } else if (roleChoose == 3) {
	// Quit();
	// } else {
	// InvalidMenuOption();
	// listBooks(librarian);
	// }
	//
	// }

	// public void listMoviesMenu(Librarian librarian) {
	// System.out.println("please choose what your role ");
	// System.out.println("1.librarian ");
	// System.out.println("2.customer ");
	// System.out.println("3.Quit");
	// Scanner scan = new Scanner(System.in);
	// int roleChoose = scan.nextInt();
	// if (roleChoose == 1) {
	// librarian.listBooksForLibaraian();
	// } else if (roleChoose == 2) {
	// librarian.listBooksForCustomer();
	// menuChooseBook(librarian);
	// } else if (roleChoose == 3) {
	// Quit();
	// } else {
	// InvalidMenuOption();
	// listBooks(librarian);
	// }
	//
	// }

	public void InvalidMenuOption() {
		System.out.println("Select a valid option!");
	}

	public void Quit() {
		System.exit(0);
	}

}
