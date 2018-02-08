package com.example.demo;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Id;
import javax.security.sasl.AuthorizeCallback;
import javax.servlet.http.HttpServletRequest;
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
    @GetMapping("/checkout")
    public String checkoutbook( Model model){

        model.addAttribute("book", library.findByAuthor("true"));
        https://github.com/aoa4eva/CourseWithSearch/blob/master/src/main/java/me/afua/demo/MainController.java
        return"listbooks";
    }
    @GetMapping("/return")
    public String returnbook(Model model){
        model.addAttribute("book", library.findAll()); //set this up to search for In = False
        return"returnbook";
    }


    @PostMapping("/processbook")
    public String processExperience(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "addbooks";
        }
        book.setIn("true");
        library.save(book);
        return "redirect:/listbooks";
    }
    @RequestMapping("/checkout/{id}")
    public String processCheckout(@PathVariable("id") long id, Model model){
        (library.findOne(id)).setIn("false");
        System.out.println(id);
        System.out.println(library.findOne(id).getIn());
        library.save(library.findOne(id));
        return "redirect:/checkout";
    }
    /*
    @PostMapping("/returnbook")
    public String processReturn(Book id){
        library.findOne(id).in = true;
        return "redirect/return";
    }*/

}
