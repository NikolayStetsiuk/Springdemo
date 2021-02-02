package com.example.springdemo.services;

import com.example.springdemo.converters.ModelToEntity;
import com.example.springdemo.entity.Book;
import com.example.springdemo.repozitory.BookRep;
import com.example.springdemo.viewModel.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServicelmpl implements BookService{

    private BookRep bookRep;
    private ModelToEntity modelToEntity;


    @Autowired
    public BookServicelmpl(BookRep bookRep, ModelToEntity modelToEntity) {
        this.bookRep = bookRep;
        this.modelToEntity = modelToEntity;
    }



    @Override
    public List<Book> listAll() {
        return null;
    }

    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public Book saveOrUpdate(Book book) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Book saveorUpdateBookModel(BookModel bookModel) {
        return null;
    }
}
