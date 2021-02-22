package com.example.springdemo.controllers;

import com.example.springdemo.services.Fileservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FileController {


    Fileservice fileservice;

    @Autowired
    public void setFileservice(Fileservice fileservice) {
        this.fileservice = fileservice;
    }
}
