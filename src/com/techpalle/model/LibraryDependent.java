package com.techpalle.model;

public class LibraryDependent 
{
	private int section_no;
	private String section_code;
	private String section_name;
	private BookIndependent book = new BookIndependent();
	
	public int getSection_no() 
	{
		return section_no;
	}
	public void setSection_no(int section_no) 
	{
		this.section_no = section_no;
	}
	public String getSection_code() 
	{
		return section_code;
	}
	public void setSection_code(String section_code) 
	{
		this.section_code = section_code;
	}
	public String getSection_name() 
	{
		return section_name;
	}
	public void setSection_name(String section_name) 
	{
		this.section_name = section_name;
	}
	public BookIndependent getBook() 
	{
		return book;
	}
	public void setBook(BookIndependent book) 
	{
		this.book = book;
	}
	
	public LibraryDependent() 
	{
		super();
	}
	
	public LibraryDependent(String section_code, String section_name, BookIndependent book) 
	{
		super();
		this.section_code = section_code;
		this.section_name = section_name;
		this.book = book;
	}
	
	public LibraryDependent(int section_no, String section_code, String section_name, BookIndependent book) 
	{
		super();
		this.section_no = section_no;
		this.section_code = section_code;
		this.section_name = section_name;
		this.book = book;
	}
}
