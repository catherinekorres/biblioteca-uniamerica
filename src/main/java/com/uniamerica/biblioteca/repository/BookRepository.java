package com.uniamerica.biblioteca.repository;

import com.uniamerica.biblioteca.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}