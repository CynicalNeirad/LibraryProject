package com.example.demo;
import org.springframework.data.repository.CrudRepository;
public  interface LibraryRepository extends CrudRepository<Book , Long>{
    Iterable<Book> findAllByBorrowed(String borrowed);
    }


