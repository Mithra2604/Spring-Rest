package com.example.SpringRest.service;

import com.example.SpringRest.models.Books;
import com.example.SpringRest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public Books addbooks(@RequestBody Books book)
    {
        return repository.save(book);

    }
    public List<Books> getallbooks(){
        return repository.findAll();
    }

    public String updatebook(@PathVariable int id, @RequestBody Books book){
        Optional<Books> existingBook= repository.findById(id);
        if(existingBook.isEmpty()){
            return "No Books Found";
        }
        else {
            existingBook.get().setAuthor((book.getAuthor()));
            existingBook.get().setBookname((book.getBookname()));
            existingBook.get().setYear((book.getYear()));
            repository.save(existingBook.get());
            return "Book Updated";
        }
    }

    public String deletebyid( int id)
    {
        repository.deleteById(id);
        return "Book Deleted";
    }

    public Books getByBookName(String name) {
        return repository.findByBookname(name);
    }
}
