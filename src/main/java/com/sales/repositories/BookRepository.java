package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Book;

//Book repository interface which handles CRUD functionality with database
@Repository
public interface BookRepository extends CrudRepository <Book, Long>  {

}
