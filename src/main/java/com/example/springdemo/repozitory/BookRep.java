package com.example.springdemo.repozitory;

import com.example.springdemo.entity.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRep extends CrudRepository<Book,Long> {

}
