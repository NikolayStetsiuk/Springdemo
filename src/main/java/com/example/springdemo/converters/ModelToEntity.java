package com.example.springdemo.converters;

import com.example.springdemo.entity.Book;
import com.example.springdemo.viewModel.BookModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class ModelToEntity implements Converter<BookModel, Book> {
    @Override
    public Book convert(BookModel bookModel) {
        Book book = new Book();

        if (bookModel.getId() != null  && !StringUtils.isEmpty(bookModel.getId())) {
            book.setId(new Long(bookModel.getId()));
        }
        book.setAuthor(bookModel.getAuthor());
        book.setImageUrl(bookModel.getImageUrl());
        book.setTitle(bookModel.getTitle());

        return book;
    }
}
