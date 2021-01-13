package com.example.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntitiController {


        @RequestMapping("/index")
        public String viewInedx(){
            return "index";
        }
}
