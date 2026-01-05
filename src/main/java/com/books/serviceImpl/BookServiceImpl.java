package com.books.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.books.entity.Books;
import com.books.repositories.BookRepositories;
import com.books.services.BookServices;

@Component
public class BookServiceImpl implements BookServices {

    private BookRepositories bookRepositories;

    public BookServiceImpl(BookRepositories bookRepositories) {
        this.bookRepositories = bookRepositories;
    }

    @Override
    public Books postBook(Books books) {
        return bookRepositories.save(books);
    }

    @Override
    public List<Books> getAllBook() {
        return bookRepositories.findAll();
    }

    @Override
    public Optional<Books> getBookById(int id) {
        return bookRepositories.findById(id);
    }

    @Override
    public boolean deleteBook(int id) {
        if (bookRepositories.existsById(id)) {
            bookRepositories.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Books updateBook(int id, Books books) {
        return bookRepositories.save(books);
    }

}
