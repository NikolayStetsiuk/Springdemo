package com.example.springdemo.converters;

import com.example.springdemo.entity.Book;
import com.example.springdemo.viewModel.BookModel;
import org.springframework.core.convert.converter.Converter;

public class ModelToEntity implements Converter<BookModel, Book> {
    @Override
    public Book convert(BookModel bookModel) {
        Book book = new Book();

        return null;
    }
}
