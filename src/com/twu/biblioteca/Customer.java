package com.twu.biblioteca;

public class Customer {
    String name;
    String id;
    String password;
    String email;
    String phoneNumber;
    public Customer(String name){
    	this.name=name;
    }
    public Customer(String name,String id,String password,String email,String phoneNumber){
    	this.name=name;
        this.id=id;
        this.password=password;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
    public Customer(String name,String id,String password){
    	this.name=name;
    	this.id=id;
    	this.password=password;
    }
    public void customerDetail(){
    	System.out.println("name:"+this.name+" email:"+this.email+" phoneNumber:"+this.phoneNumber);
    }
    
}
