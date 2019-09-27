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
import com.sales.models.Customer;
import com.sales.services.CustomerService;

//Customer controller class to handle Customer pages
@Controller
public class CustomerController {
	@Autowired
	CustomerService cs;
	
	//mapping for show customers page
	@RequestMapping(value="/showCustomers")
	public String listCustomers(Model model)
	{
		//Initialise ArrayList with customers from the database by calling getCustomers from customer service
		 ArrayList<Customer> customers =  (ArrayList<Customer>) cs.getCustomers();
		 
		//Add ArrayList of customers to model to be displayed
		 model.addAttribute("customers",customers);
	
		//Return jsp page filename for showCustomers, this displays the page for the user
		return "showCustomers";	
	}
	
	//Mapping for adding a new customer page (mapping for GET request)
	@RequestMapping(value="/addCustomer")
	public String addCustomer(Model model)
	{
		//Create a new customer instance
		Customer customer = new Customer();
		
		//add the new instance to the model to allow user entry into customer
		model.addAttribute("custAdded",customer);
		
		//return jsp filename
		return "addCustomer";
		
	}
	
	//Method for posting/adding a new customer to database that the user has entered
	@RequestMapping(value="/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute ("custAdded") Customer customer,BindingResult bindingResult, Model model)
	{
		//display errors if left empty e.g. "May not be null" and "Must be greater or equal to one"
		if(bindingResult.hasErrors()) 
		{
			//redisplay page as errors exist
			return "addCustomer";
		}
		
		//call add customer method to add to database
		cs.addCustomer(customer);
		
		//get all customers in an ArrayList and add to model, including new customer added
		ArrayList<Customer> customers =  (ArrayList<Customer>) cs.getCustomers();
		model.addAttribute("customers",customers);
		return "showCustomers";	
	}
}
