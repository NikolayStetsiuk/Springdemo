package com.example.springdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UploadFile {

    private UploadFile uploadFile;

    @Autowired
    public void setUploadFile(UploadFile uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String uploadFile(){
        return "";
    }
}
