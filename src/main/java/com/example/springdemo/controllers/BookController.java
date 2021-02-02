package com.example.springdemo.controllers;

import com.example.springdemo.converters.EntityToModel;
import com.example.springdemo.services.BookService;
import com.example.springdemo.viewModel.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookService bookService;
    private EntityToModel entityToModel;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setEntityToModel(EntityToModel entityToModel) {
        this.entityToModel = entityToModel;
    }

    @RequestMapping("/book/list")
    public String listBook(Model model) {
        model.addAttribute("books", bookService.listAll());
        return "/book/list";
    }

    @RequestMapping("/book/new")
    public String newProduct(Model model){
        model.addAttribute("modelBook", new BookModel());
        return "book/formBook";
    }

}
