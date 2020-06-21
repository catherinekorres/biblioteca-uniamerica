package com.uniamerica.biblioteca.controller;

import com.uniamerica.biblioteca.model.Author;
import com.uniamerica.biblioteca.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.save(author));
    }

    @GetMapping
    public ResponseEntity<List<Author>> list() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@RequestBody Author author, @PathVariable Long id) {
        return ResponseEntity.ok(authorService.update(author, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> delete(@PathVariable Long id) {
        Author deleted = authorService.delete(id);

        if (deleted == null) {
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }

        return new ResponseEntity<>(deleted, HttpStatus.EXPECTATION_FAILED);
    }
}
