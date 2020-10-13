package com.example.weblibrary;

import com.example.weblibrary.repository.library.CategoryRepository;
import com.example.weblibrary.repository.user.RoleRepository;
import com.example.weblibrary.repository.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WebLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebLibraryApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(
            UserRepository userRepository,
            RoleRepository roleRepository,
            CategoryRepository categoryRepository,
            PasswordEncoder bCryptPasswordEncoder) {
        return args -> {
            /**USERS DEFAULT DATA*/
//            Role adminRole = roleRepository.save(new Role("ROLE_ADMIN"));
//            Role userRole = roleRepository.save(new Role("ROLE_USER"));
//
//            userRepository.save(new User("Librarian", bCryptPasswordEncoder.encode("12345"), new HashSet<>(Collections.singletonList(adminRole))));
//            userRepository.save(new User("Reader_1", bCryptPasswordEncoder.encode("12345"), new HashSet<>(Collections.singletonList(userRole))));

            /**DEFAULT BOOKS AND CATEGORIES*/

//            Book book1 = new Book("Harry Potter", "J.K. Rowling", "Fantasy book about magicians");
//            Book book2 = new Book("God Father", "Mario Puzo", "This book about money and criminal");
//            Book book3 = new Book("Romeo and Juliet", "William Shakespeare", "Book about love");
//            Book book4 = new Book("Einstein: The Man, the Genius, and the Theory of Relativity", "Walter Isaacson", "Albert Einstein's biography");
//            Book book5 = new Book("Benjamin Franklin: An American Life", "Walter Isaacson", "Benjamin Franklin's biography");
//
//            Category category1 = new Category("Fantasy", new HashSet<>(Collections.singletonList(book1)));
//            Category category2 = new Category("Criminal", new HashSet<>(Collections.singletonList(book2)));
//            Category category3 = new Category("Romance", new HashSet<>(Collections.singletonList(book3)));
//            Category category4 = new Category("Biography", new HashSet<>(Arrays.asList(book4, book5)));
//
//            categoryRepository.save(category1);
//            categoryRepository.save(category2);
//            categoryRepository.save(category3);
//            categoryRepository.save(category4);
        };
    }
}
