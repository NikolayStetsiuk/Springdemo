package com.example.springdemo.controllers;

import com.example.springdemo.repozitory.BookRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "index")
public class BookController {

    private BookRep bookRep;

    @RequestMapping("/index")

    public String viewInedx() {
        return "index";
    }
}
