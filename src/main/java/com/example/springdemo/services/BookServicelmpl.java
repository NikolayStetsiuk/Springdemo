package com.example.springdemo.services;

import com.example.springdemo.converters.ModelToEntity;
import com.example.springdemo.entity.Book;
import com.example.springdemo.repozitory.BookRepository;
import com.example.springdemo.viewModel.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServicelmpl implements BookService{

    private BookRepository bookRepository;
    private ModelToEntity modelToEntity;

    @Autowired
    public BookServicelmpl(BookRepository bookRepository, ModelToEntity modelToEntity) {
        this.bookRepository = bookRepository;
        this.modelToEntity = modelToEntity;
    }



    @Override
    public List<Book> listAll() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books :: add);
        return books;
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book saveOrUpdate(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book saveorUpdateBookModel(BookModel bookModel) {
        Book savedBook = saveOrUpdate(modelToEntity.convert(bookModel));
        System.out.println("Saved Book Id:" + savedBook.getId());
        return savedBook;
    }



}
