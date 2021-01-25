package com.example.springdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "index")
public class BookController {


    @RequestMapping("/index")

    public String viewInedx() {
        return "index";
    }
}
