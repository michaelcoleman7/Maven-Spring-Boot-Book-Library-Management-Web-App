package com.sales.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Book;
import com.sales.services.BookService;

//Book controller class to handle book pages
@Controller
public class BookController {
	@Autowired
	BookService bs;
	
	//mapping for show books page
	@RequestMapping(value="/showBooks")
	public String listBooks(Model model)
	{
		//Initialise ArrayList with books from the database by calling getBooks from book service
		 ArrayList<Book> books =  (ArrayList<Book>) bs.getBooks();
		 
		 //Add ArrayList of books to model to be displayed
		 model.addAttribute("books",books);
	
		//Return jsp page filename for showBooks, this displays the page for the user
		return "showBooks";
		
	}
	
	//Mapping for adding a new book page (mapping for GET request)
	@RequestMapping(value="/addBook")
	public String addBook(Model model)
	{
		//Create a new book instance
		Book book = new Book();
		//add the new instance to the model to allow user entry into book
		model.addAttribute("bookAdded",book);
		
		//return jsp filename
		return "addBook";
		
	}
	
	//Method for posting/adding a new book to database that the user has entered
	@RequestMapping(value="/addBook", method = RequestMethod.POST)
	public String addBook(@Valid @ModelAttribute ("bookAdded") Book book,BindingResult bindingResult, Model model)
	{
		//display errors if left empty e.g. "May not be null"
	    if (bindingResult.hasErrors()) {
	    	//redisplay page as errors exist
	        return "addBook";
	    }
	    //Add the new book to the database
		bs.addBook(book);
		
	    //populate array with books in database including newly added book
		ArrayList<Book> books =  (ArrayList<Book>) bs.getBooks();
		//add ArrayList to model and display new page
		model.addAttribute("books",books);
		return "showBooks";	
	}
}
