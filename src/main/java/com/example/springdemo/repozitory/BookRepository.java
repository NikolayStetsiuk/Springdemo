package com.example.springdemo.repozitory;

import com.example.springdemo.entity.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book,Long> {

}
