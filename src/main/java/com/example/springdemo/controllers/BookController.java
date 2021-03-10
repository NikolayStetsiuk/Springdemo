package com.example.springdemo.controllers;

import com.example.springdemo.converters.EntityToModel;
import com.example.springdemo.entity.Book;
import com.example.springdemo.services.BookService;
import com.example.springdemo.viewModel.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

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

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/book/greeting")
    public String greeting(){
        return "book/greeting";
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/book/list";
    }

    @RequestMapping({"/book/list","/book"})
    public String listBook(Model model) {
        model.addAttribute("books", bookService.listAll());
        return "/book/list";
    }

    @RequestMapping("/book/show/{id}")
    public String getBook(@PathVariable String id, Model model){
        model.addAttribute("books",bookService.getById(Long.valueOf(id)));
        return "book/show";
    }

    @RequestMapping("book/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Book book = bookService.getById(Long.valueOf(id));
        BookModel bookModel = entityToModel.convert(book);

        model.addAttribute("modelBook",bookModel);
        return "book/formBook";
    }

    @RequestMapping("/book/new")
    public String newBook(Model model){
        model.addAttribute("modelBook", new BookModel());
        return "book/formBook";
    }

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String saveOrUpdateBook(@RequestParam("fileName") MultipartFile file,@Valid BookModel bookModel, BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()){
            return "book/formBook";
        }

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

        }

        Book savedBook = bookService.saveorUpdateBookModel(bookModel);
        return "redirect:/book/show/" + savedBook.getId();
    }

    @RequestMapping("book/delete/{id}")
    public String delete(@PathVariable String id){
        bookService.delete(Long.valueOf(id));
        return "redirect:/book/list";
    }



}
