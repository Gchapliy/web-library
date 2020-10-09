package com.example.weblibrary.model.library;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    @Column(name = "short_description")
    private String shortDescription;
    @ManyToMany(mappedBy = "books")
    private Set<Category> category;
}
