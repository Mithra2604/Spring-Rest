package com.example.SpringRest.repository;

import com.example.SpringRest.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Books,Integer> {
    Books findByBookname(String name);
}
