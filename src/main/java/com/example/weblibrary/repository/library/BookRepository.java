package com.example.weblibrary.repository.library;

import com.example.weblibrary.model.library.Book;
import com.example.weblibrary.model.library.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findAllByCategory(Category category);

    @Query("select b from Book b where lower(b.name) like lower(concat('%', concat(?1, '%')))")
    public List<Book> findAllByNameLike(String name);
}
