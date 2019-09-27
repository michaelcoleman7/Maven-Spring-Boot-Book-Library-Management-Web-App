package com.sales.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

//Customer service to communicate between repository and controller
@Service
public class CustomerService {
	@Autowired
	CustomerRepository cr;
	//Method to return an ArrayList of customers in the database
	public Iterable<Customer> getCustomers()
	{
		//BookRepository finds all customers in database and returns as an ArrayList
		return cr.findAll();
	}
	
	//Method to find a specific customer from the database
	public Customer findCustomer(Customer customer)
	{
		//CustomerRepository finds customer by customer id and returns it
		return cr.findOne(customer.getcId());
	}
	
	//Method to save new customer to database
	public void addCustomer(Customer customer)
	{
		//CustomerRepository saves new customer to the database
		cr.save(customer);
	}
}
