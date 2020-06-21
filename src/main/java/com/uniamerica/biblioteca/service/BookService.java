package com.uniamerica.biblioteca.service;

import com.uniamerica.biblioteca.model.Book;
import com.uniamerica.biblioteca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findOne(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book update(Book book, Long id) {
        Book updated = this.findOne(id);

        updated.setName(book.getName());
        updated.setIsbn(book.getIsbn());
        updated.setAuthors(book.getAuthors());

        return bookRepository.save(updated);
    }

    public Book delete(Long id) {
        bookRepository.deleteById(id);
        return this.findOne(id); // Retorna nulo caso delete
    }
}
