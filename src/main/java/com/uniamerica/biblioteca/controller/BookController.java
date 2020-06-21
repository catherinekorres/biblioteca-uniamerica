package com.uniamerica.biblioteca.controller;

import com.uniamerica.biblioteca.model.Book;
import com.uniamerica.biblioteca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> list() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable Long id) {
        return ResponseEntity.ok(bookService.update(book, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        Book deleted = bookService.delete(id);

        if (deleted == null) {
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }

        return new ResponseEntity<>(deleted, HttpStatus.EXPECTATION_FAILED);
    }
}
