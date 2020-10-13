package com.example.weblibrary.service.library;

import com.example.weblibrary.model.library.Book;
import com.example.weblibrary.model.library.Category;
import com.example.weblibrary.repository.library.BookRepository;
import com.example.weblibrary.repository.library.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public Set<Book> findAll() {
        return new HashSet<>(bookRepository.findAll());
    }

    public Set<Book> findAllBooksByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).get();

        return category.getBooks();
    }

    public void addBookToCategory(Long bookId, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).get();

        if (category != null) {
            Book book = bookRepository.findById(bookId).get();

            if (book != null) {
                category.getBooks().add(book);

                categoryRepository.save(category);
            }
        }
    }

    public void removeCategoryFromBook(Long bookId, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).get();

        if (category != null) {
            Book book = bookRepository.findById(bookId).get();

            if (book != null) {
                category.setBooks(category.getBooks().stream()
                        .filter(bookFilter -> bookFilter.getId().equals(bookId))
                        .collect(Collectors.toSet()));

                categoryRepository.save(category);
            }
        }
    }

    public List<Book> findAllByName(String bookName){
        return bookRepository.findAllByNameLike(bookName);
    }
}
