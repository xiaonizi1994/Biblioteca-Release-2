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
//		//System.out.println("��¥�Ρ��������塢���μǡ�ˮ䰴�");
//		return "��¥�Ρ��������塢���μǡ�ˮ䰴�";
//	}
//
//	public static String detals(String author,String published) {
//		// TODO Auto-generated method stub
//		Book book=new Book("xiaoming","1999");
//		book.detail();
//		return book;
//	}
	
}
