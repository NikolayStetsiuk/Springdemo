package com.example.springdemo.converters;


import com.example.springdemo.entity.Book;
import com.example.springdemo.viewModel.BookModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EntityToModel implements Converter<Book, BookModel> {
    @Override
    public BookModel convert(Book book) {
        BookModel bookModel = new BookModel();
        bookModel.setId(book.getId());
        bookModel.setAuthor(book.getAuthor());
        bookModel.setTitle(book.getTitle());
        bookModel.setImageUrl(book.getImageUrl());
        bookModel.setFileName(book.getFileName());
        return bookModel;
    }
}
