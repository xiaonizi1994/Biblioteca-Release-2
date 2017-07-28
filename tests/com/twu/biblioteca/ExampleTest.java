package com.twu.biblioteca;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExampleTest {
	private final OutputStream outputStream = new ByteArrayOutputStream();
	private final OutputStream errStream = new ByteArrayOutputStream();

	private String getOutput() {
		return outputStream.toString().trim();
	}

	private BibliotecaApp App() {
		return new BibliotecaApp();
	}

	private Book bookSanti() {
		Book book = new Book("santi");
		return book;
	}

	private Book bookXiyouji() {
		Book book = new Book("xiyouxi");
		return book;
	}

	private Movie movieBlackbird() {
		Movie movie = new Movie("Blackbird", "2014", "Gina Prince-Bythewood", "G");
		return movie;
	}

	private Movie movieStory0fYourLife() {
		Movie movie = new Movie("Story of Your Life", " 2016", "Denis Villeneuve", "G");
		return movie;
	}

	private Customer customerLily() {
		Customer customer = new Customer("Lily");
		return customer;
	}

	private Customer customerJune() {
		Customer customer = new Customer("June");
		return customer;
	}

	private Librarian librarian() {
		Book book1 = bookXiyouji();
		Book book2 = bookSanti();
		Movie movie1 = movieBlackbird();
		Movie movie2 = movieStory0fYourLife();
		Book[] books = { book1, book2 };
		Movie[] movies = { movie1, movie2 };
		Librarian librarian = new Librarian(books, movies);
		return librarian;
	}

	@Before
	public void setOutStream() {
		System.setOut(new PrintStream(outputStream));
		System.setErr(new PrintStream(errStream));
	}

	@After
	public void resetOutStream() {
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	public void welcomeTest() throws Exception {
		App().welcome();
		assertEquals("welcome", getOutput());
	}

	// @Test
	// public void listBooksForCustomerTest() throws Exception {
	// Customer customer=customer();
	// Librarian librarian = librarian();
	// Book[] books={bookXiaoming(),bookWuChengen()};
	// AssertArrayEquals(books,librarian.listBooksTestForCustomer());
	// }

	@Test
	public void bookDetailsTest() throws Exception {
		Book book = bookXiyouji();
		book.bookInfo("wuchengen", "1994");
		assertEquals(" Author:wuchengen " + "Published:1994", book.detail());
	}

	// @Test
	// public void MainMenuTest() throws Exception {
	// assertEquals("1.List Books",new mainMenu().mainMenuShow());
	// }
	@Test
	public void InvalidMenuOptionTest() throws Exception {
		new mainMenu().InvalidMenuOption();
		assertEquals("Select a valid option!", getOutput());
	}

	@Test
	public void quitTest() throws Exception {

	}

	@Test
	public void CheckoutBookTestIsCheckOutTrue() throws Exception {
		Customer customer = customerLily();
		// Librarian librarian = librarian();
		Book book = bookXiyouji();
		book.checkoutBook(customer);
		assertEquals(true, book.isCheckout);

	}

	@Test
	public void CheckoutBookTestIsCheckOutfalse() throws Exception {
		// Librarian librarian=new Librarian();
		// Customer customer=new Customer("lily");
		// librarian.checkoutBook(book,customer);
		assertEquals(false, bookXiyouji().isCheckout);

	}

	@Test
	public void CheckoutBookTestCheckedNameLily() throws Exception {
		Book book = bookXiyouji();
		Customer customer = customerLily();
		book.checkoutBook(customer);
		assertEquals("Lily", book.checkedName);
	}

	@Test
	public void CheckoutBookTestCheckedNameNull() throws Exception {
		// Librarian librarian=new Librarian();
		// Customer customer=new Customer("lily");
		// librarian.checkoutBook(book,customer);
		assertEquals("", bookXiyouji().checkedName);
	}

	@Test
	public void CheckoutBookTestSuccess() throws Exception {
		Customer customer = customerLily();
		// Librarian librarian = librarian();
		Book book = bookXiyouji();
		book.checkoutBook(customer);
		assertEquals("Thank you! Enjoy the book.", getOutput());

	}

	@Test
	public void CheckoutBookTestfail() throws Exception {
		Customer customer1 = customerLily();
		Customer customer2 = customerJune();
		// Librarian librarian = librarian();
		Book book = bookXiyouji();
		book.isCheckout = true;
		book.checkoutBook(customer1);
		assertEquals("That book is not available.", getOutput());

	}

	@Test
	public void successCheckoutTest() throws Exception {
		Book book = bookXiyouji();
		book.successCheckout();
		assertEquals("Thank you! Enjoy the book.", getOutput());

	}

	@Test
	public void failCheckoutTest() throws Exception {
		Book book = bookXiyouji();
		book.failCheckout();
		assertEquals("That book is not available.", getOutput());

	}

	@Test
	public void successReturnTest() throws Exception {
		Book book = bookXiyouji();
		book.successReturn();
		assertEquals("Thank you for returning the book.", getOutput());
	}

	@Test
	public void failReturnTest() throws Exception {
		Book book = bookXiyouji();
		book.failReturn();
		assertEquals("That is not a valid book to return.", getOutput());
	}

	@Test
	public void returnBookTestIsCheckOutFalse() throws Exception {
		Customer customer = customerLily();
		Book book = bookXiyouji();
		book.checkoutBook(customer);
		book.returnBook(customer);
		assertEquals(false, book.isCheckout);
	}

	@Test
	public void returnBookTestSuccess() throws Exception {
		Customer customer = customerLily();
		Book book = bookXiyouji();
		// book.checkoutBook(customer);
		// resetOutStream();
		book.isCheckout = true;
		book.checkedName = "Lily";
		book.returnBook(customer);
		assertEquals("Thank you for returning the book.", getOutput());
		// book.returnBook();
		// assertEquals(false,book.isCheckout);
	}

	@Test
	public void returnBookTestFail() throws Exception {
		Customer customer = customerLily();
		Book book = bookXiyouji();
		book.isCheckout = true;
		book.checkedName = "June";
		book.returnBook(customer);
		assertEquals("That is not a valid book to return.", getOutput());
	}

	@Test
	public void movieDetailTest() throws Exception {
		Movie movie = movieBlackbird();
		assertEquals(" name:Blackbird" + " year:2014" + " director:Gina Prince-Bythewood" + " movie rating:G",
				movie.detail());
	}

//	@Test
//	public void listMoviesTest() throws Exception {
//		Librarian librarian = Librarian();
//		librarian.listMoviesForCustomer();
//		assertEquals(
//				"1 name:Blackbird year:2014 director:Gina Prince-Bythewood movie rating:G isCheckOut:false" + "\n"
//						+ "2 name:Story of Your Life year: 2016 director:Denis Villeneuve movie rating:G isCheckOut:false",
//				getOutput());
//	}
	@Test
	public void successCheckoutMovieTest() throws Exception {
		Movie movie=movieBlackbird();
		movie.successCheckout();
		assertEquals("Thank you! Enjoy the movie.", getOutput());

	}

	@Test
	public void failCheckoutMovieTest() throws Exception {
		Movie movie=movieBlackbird();
		movie.failCheckout();
		assertEquals("That movie is not available.", getOutput());

	}
	@Test
	public void CheckoutMovieTestSuccess() throws Exception {
		Customer customer=customerJune();
		Movie movie=movieBlackbird();
		movie.checkoutMovie(customer);
		assertEquals("Thank you! Enjoy the movie.", getOutput());
		
	}
	@Test
	public void CheckoutMovieTestFail() throws Exception {
		Customer customer=customerJune();
		Movie movie=movieBlackbird();
		movie.isCheckout=true;
		movie.checkedName="xixi";
		movie.checkoutMovie(customer);
		assertEquals("That movie is not available.", getOutput());
	}
	@Test
	public void loginTest() throws Exception {
		
	}
}
