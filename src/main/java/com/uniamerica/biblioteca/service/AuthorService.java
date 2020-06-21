package com.uniamerica.biblioteca.service;


import com.uniamerica.biblioteca.model.Author;
import com.uniamerica.biblioteca.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Author findOne(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author update(Author author, Long id) {
        Author updated = this.findOne(id);

        updated.setName(author.getName());

        return authorRepository.save(updated);
    }

    public Author delete(Long id) {
        authorRepository.deleteById(id);
        return this.findOne(id); // Retorna nulo caso delete
    }
}