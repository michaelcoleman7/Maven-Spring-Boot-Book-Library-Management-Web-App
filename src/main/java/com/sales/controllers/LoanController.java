package com.sales.controllers;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Loan;
import com.sales.services.LoanService;

//Loan controller class to handle Loan pages
@Controller
public class LoanController {
	@Autowired
	LoanService ls;
	
	//mapping for show loans page
	@RequestMapping(value="/showLoans")
	public String listLoans(Model model)
	{
		//Initialise ArrayList with loans from the database by calling getLoans from loan service
		 ArrayList<Loan> loans =  (ArrayList<Loan>) ls.getLoans();
		 
		//Add ArrayList of customers to model to be displayed
		 model.addAttribute("loans",loans);
	
		//Return jsp page filename for showLoans, this displays the page for the user
		return "showLoans";	
	}
	
	//Mapping for adding a new loan page (mapping for GET request)
	@RequestMapping(value="/newLoan")
	public String addLoan(Model model)
	{
		//Create a new loan instance
		Loan loan = new Loan();
		
		//add the new instance to the model to allow user entry into loan
		model.addAttribute("loanAdded",loan);
		
		//return jsp filename
		return "newLoan";
	}
	
	//Method for posting/adding a new loan to database that the user has entered
	@RequestMapping(value="/newLoan", method = RequestMethod.POST)
	public String addLoan(@ModelAttribute ("loanAdded") Loan loan,BindingResult bindingResult, Model model)
	{
		//added id's to binding errors as leaving blank loan cid and bid doesn't return error messages as not set to @NotBlank in Loan.java
		if(bindingResult.hasErrors() || loan.getCust().getcId() == null || loan.getBook().getBid() == null) 
		{
			//redisplay page as errors exist
			return "newLoan";
		}
		
		//call add loan method to try to add to database, which returns the string which determines if book id/customer id exists
		//if so ,it is added to database, if not error handled using string returned
		String saved = ls.addLoan(loan);
		
		//if the returned string doesn't = "saved" then an error has occurred 
		//(i.e either customer id or book id doesn't exist or both) individual error displayed for each error
		if(!saved.equals("saved")) 
		{
			//add error string to model and display it on loan error page
			model.addAttribute("error",saved);
			return "addLoanError";	
		}
		
		//get all loans in an ArrayList and add to model, including new loan added
		ArrayList<Loan> loans =  (ArrayList<Loan>) ls.getLoans();
		model.addAttribute("loans",loans);
		return "showLoans";	
	}
	
	//Mapping to display deleting loans page
	@RequestMapping(value="/deleteLoan")
	public String deleteLoan(Model model)
	{
		//create a new instance of loan
		Loan loan = new Loan();
		//add instance to model and display delete page
		model.addAttribute("loanToDelete",loan);
		return "deleteLoan";
	}
	
	//Mapping to deal with post requests from delete page
	@RequestMapping(value="/deleteLoan", method = RequestMethod.POST)
	public String deleteLoan(@ModelAttribute ("loanToDelete") Loan loan,BindingResult bindingResult,Model model)
	{
			//call delete loan method which deletes from database if exists and error handled by string returned if loan id doesn't exist
			String deleted = ls.deleteLoan(loan);
			//if deleted doesnt = "deleted" then display that id doesn't exist on delete loan error page
			if(!deleted.equals("deleted")) 
			{
				//add deleted string to the model and display error page
				model.addAttribute("error",deleted);
				return "deleteLoanError";	
			}
			
			//get all loans in an ArrayList and add to model, loan deleted is not read as no longer exists
			ArrayList<Loan> loans =  (ArrayList<Loan>) ls.getLoans();
			//add loans to model and display loans page
			model.addAttribute("loans",loans);
			return "showLoans";		
	}
}
