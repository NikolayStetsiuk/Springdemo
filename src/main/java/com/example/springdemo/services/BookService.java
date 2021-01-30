package com.example.springdemo.services;

import com.example.springdemo.entity.Book;
import com.example.springdemo.viewModel.BookModel;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    Book getById(Long id);
    Book saveOrUpdate(Book book);
    void delete(Long id);
    Book saveorUpdateBookModel(BookModel bookModel);
}
