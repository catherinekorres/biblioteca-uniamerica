package com.uniamerica.biblioteca.model;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    private Long id;

    @Column
    private String name;
}
