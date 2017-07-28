package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        welcome();
        mainMenu menu=new mainMenu();
        menu.mainMenuShow();
      //  listBooks();
        //detals();
    }

	public static void welcome() {
		System.out.println("welcome");
	}
//	public static String listBooks() {
//		//System.out.println("红楼梦、三国演义、西游记、水浒传");
//		return "红楼梦、三国演义、西游记、水浒传";
//	}
//
//	public static String detals(String author,String published) {
//		// TODO Auto-generated method stub
//		Book book=new Book("xiaoming","1999");
//		book.detail();
//		return book;
//	}
	
}
