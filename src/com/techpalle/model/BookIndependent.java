package com.techpalle.model;

public class BookIndependent 
{
	private int book_no;
	private String book_name;
	private String publisher;
	private String subject;
	private String author;
	private String price;
	
	public int getBook_no() 
	{
		return book_no;
	}
	public void setBook_no(int book_no) 
	{
		this.book_no = book_no;
	}
	public String getBook_name() 
	{
		return book_name;
	}
	public void setBook_name(String book_name) 
	{
		this.book_name = book_name;
	}
	public String getPublisher() 
	{
		return publisher;
	}
	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}
	public String getSubject() 
	{
		return subject;
	}
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
	public String getAuthor() 
	{
		return author;
	}
	public void setAuthor(String author) 
	{
		this.author = author;
	}
	public String getPrice() 
	{
		return price;
	}
	public void setPrice(String price) 
	{
		this.price = price;
	}
	
	public BookIndependent() 
	{
		super();
	}
	
	public BookIndependent(String book_name, String publisher, String subject, String author, String price) 
	{
		super();
		this.book_name = book_name;
		this.publisher = publisher;
		this.subject = subject;
		this.author = author;
		this.price = price;
	}
	
	public BookIndependent(int book_no, String book_name, String publisher, String subject, String author,
			String price) 
	{
		super();
		this.book_no = book_no;
		this.book_name = book_name;
		this.publisher = publisher;
		this.subject = subject;
		this.author = author;
		this.price = price;
	}
}
