package com.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.books.entity.Books;

@Service
public interface BookServices {


    Books postBook(Books books);
    List<Books> getAllBook();
    Optional<Books> getBookById(int id);
    boolean deleteBook(int id);
    Books updateBook(int id, Books books);
}
