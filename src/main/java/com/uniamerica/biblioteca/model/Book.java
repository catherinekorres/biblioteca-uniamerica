package com.uniamerica.biblioteca.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String isbn;

    @ManyToMany
    private List<Author> authors;
}
