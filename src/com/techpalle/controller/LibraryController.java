package com.techpalle.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techpalle.model.LibraryDependent;

public class LibraryController 
{
	public static void main(String[] args) 
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		LibraryDependent ld = (LibraryDependent) ac.getBean("libraryd");
		System.out.println(ld.getSection_no());
		System.out.println(ld.getSection_code());
		System.out.println(ld.getSection_name());
		System.out.println(ld.getBook().getBook_no());
		System.out.println(ld.getBook().getBook_name());
		System.out.println(ld.getBook().getAuthor());
		System.out.println(ld.getBook().getPublisher());
		System.out.println(ld.getBook().getSubject());
		System.out.println(ld.getBook().getPrice());
	}
}
