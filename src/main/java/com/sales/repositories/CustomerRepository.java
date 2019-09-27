package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Customer;
//Customer repository interface which handles CRUD functionality with database
@Repository
public interface CustomerRepository extends CrudRepository <Customer, Long> {

}
