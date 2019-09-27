package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Book;
import com.sales.repositories.BookRepository;

//Book service to communicate between repository and controller
@Service
public class BookService {
	@Autowired
	BookRepository br;
	//Method to return an ArrayList of books in the database
	public Iterable<Book> getBooks()
	{
		//BookRepository finds all books in database and returns as an ArrayList
		return br.findAll();
	}
	
	//Method to find a specific book from the database
	public Book findBook(Book book)
	{
		//BookRepository finds book by book id and returns it
		return br.findOne(book.getBid());
	}
	
	//Method to add book to the database
	public void addBook(Book book)
	{
		//BookRepository saves new book to the database
		br.save(book);
	}

}
