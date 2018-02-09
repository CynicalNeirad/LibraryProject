package com.example.demo;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    LibraryRepository library;

    @GetMapping("/")
    public String mainpage(Model model) {
        return "mainpage";
    }


    @GetMapping("/listbooks")
    public String booklist(Model model) {
        model.addAttribute("book", library.findAll());
        return "listbooks";
    }

    @GetMapping("/addbooks")
    public String addbooks(Model model){
        model.addAttribute("book", new Book());
        return"addbooks";
    }
    @GetMapping("/checkoutbook")
    public String checkoutbook( Model model){

        model.addAttribute("book", library.findAllByBorrowed("In"));
        return"takeoutbook";
    }
    @GetMapping("/returnbooks")
    public String returnbook(Model model){
        model.addAttribute("book", library.findAllByBorrowed("Out")); //set this up to search for In = False
        return"returnbook";
    }


    @PostMapping("/processbook")
    public String processExperience(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "addbooks";
        }
        book.setBorrowed("In");
        if (book.getBookPicture().isEmpty() == true){
            book.setBookPicture("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Book_Collage.png/1920px-Book_Collage.png");}
        library.save(book);
        return "redirect:/listbooks";
    }
    @RequestMapping("/checkout/{id}")
    public String processCheckout(@PathVariable("id") long id, Model model){
        (library.findOne(id)).setBorrowed("Out");
        library.save(library.findOne(id));
        model.addAttribute("book", library.findOne(id));
        return "/checkedoutBookinfo";
    }

    @RequestMapping("/return/{id}")
    public String processReturn(@PathVariable("id") long id, Model model){
        (library.findOne(id)).setBorrowed("In");
        library.save(library.findOne(id));
        model.addAttribute("book", library.findOne(id));
        return "/checkedoutBookinfo";

    }

}
