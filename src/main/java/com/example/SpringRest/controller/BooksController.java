package com.example.SpringRest.controller;

import com.example.SpringRest.models.Books;
import com.example.SpringRest.repository.BookRepository;
import com.example.SpringRest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService service;

    @PostMapping("/addbook")
    public Books addbooks(@RequestBody Books book) {
        return service.addbooks(book);

    }

    @GetMapping("/getallbooks")
    public List<Books> getallbooks() {
        return service.getallbooks();
    }

    @PutMapping("/update/{id}")
    public String updatebook(@PathVariable int id, @RequestBody Books book) {
        return service.updatebook(id, book);
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deletebyid(@PathVariable int id) {
        return service.deletebyid(id);
    }

    @GetMapping("/getbyBookName/{name}")
    public Books getByName(@PathVariable String name){
        return service.getByBookName(name);

}
   }



