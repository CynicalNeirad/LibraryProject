package com.example.demo;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String bookTitle;
    @NotEmpty
    private String author;
    @NotEmpty
    private String year;
    private String isbn;
    private String borrowed;
    private String bookPicture;


    public String getBookPicture() {
        return bookPicture;
    }

    public void setBookPicture(String bookPicture) {
        this.bookPicture = bookPicture;
    }

    public String getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(String borrowed) {
        this.borrowed = borrowed;
    }

    /*private image image (?)*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


}
