package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Loan;
//Loan repository interface which handles CRUD functionality with database
@Repository
public interface LoanRepository extends CrudRepository <Loan, Long> {

}
