package com.example.springdemo.repozitory;

import com.example.springdemo.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book,Long> {
}
