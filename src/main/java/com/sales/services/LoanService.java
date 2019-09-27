package com.sales.services;

import java.time.LocalDate;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.repositories.LoanRepository;

//Loan service to communicate between repository and controller
@Service
public class LoanService {
	@Autowired
	LoanRepository lr;
	@Autowired
	CustomerService cs;
	@Autowired
	BookService bs;
	
	//Method to return an ArrayList of loans in the database
	public Iterable<Loan> getLoans()
	{
		//LoanRepository finds all loans in database and returns as an ArrayList
		return lr.findAll();
	}
	
	//Method to add loan to database
	public String addLoan(Loan loan)
	{
		//find if book user entered exists by searching for book id they entered
		Book book = bs.findBook(loan.getBook());
		//find if customer user entered exists by searching for customer id they entered
		Customer customer = cs.findCustomer(loan.getCust());
		
		//initialise loans to all loans in database
		ArrayList<Loan> loans =  (ArrayList<Loan>) getLoans();
		//loop through all loans to see if book user entered is already on loan
		for(int i=0; i<loans.size();i++)
		{
			//if a loan in array of loans has the same book as user requests, send back error message
			if(loans.get(i).getBook() == book) 
			{
				return "Book: "+loan.getBook().getBid()+" ("+loans.get(i).getBook().getTitle()+") already on loan to Customer: "
						+loans.get(i).getCust().getcId()+" ("+loans.get(i).getCust().getcName()+")";
			}	
		}
		//if book id and customer id user searched for doesn't exist then return specific error message
		if(book == null && customer == null) 
		{
			return "No such customer: "+loan.getCust().getcId()+" No such book: "+loan.getBook().getBid();
		}
		//if just the book id doesn't exist then return that information to the user
		else if(book == null) 
		{
			return " No such book: "+loan.getBook().getBid();
		}
		//if just the customer id doesn't exist then return that information to the user
		else if(customer == null) 
		{
			return "No such customer: "+loan.getCust().getcId();
		}
		
		//if found set the found book and customer to the new loans book and customer
		loan.setBook(book);
		loan.setCust(customer);
		
		//Get due date by adding customers loan period to the date, referenced http://www.java2s.com/Tutorials/Java/Data_Type_How_to/Date/Add_days_and_year_to_local_date.htm
		LocalDate localDueDate = LocalDate.now().plusDays(loan.getCust().getLoanPeriod());
		String dueDate = localDueDate.toString();//convert from LocalDate to string
		//Set loans due date to calculated due date
		loan.setDueDate(dueDate);
		
		//save loan to database
		lr.save(loan);
		//return saved to controller so that it knows loan has been successfully saved
		return "saved";
	}
	
	public String deleteLoan(Loan loan)
	{
		//initialise loans to all loans in database
		ArrayList<Loan> loans =  (ArrayList<Loan>) getLoans();
		
		//loop through all loans to see if requested delete id exists in loans array
		for(int i=0; i<loans.size();i++) 
		{
			//search if loan id in loans array is equal to the requested deletion id 
			if(loans.get(i).getLid().toString().equals(loan.getLid().toString())) 
			{
				//loan found so delete loan from database
				lr.delete(loan);
				//return deleted to controller so that it knows loan has been successfully deleted
				return "deleted";
			}
		}
		//return the loan id as a string from error handling
		return loan.getLid().toString();
	}
}
