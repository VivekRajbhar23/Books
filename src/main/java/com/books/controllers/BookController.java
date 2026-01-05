package com.books.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.entity.Books;
import com.books.serviceImpl.BookServiceImpl;

@RestController
public class BookController {

    private BookServiceImpl bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping("/books")
    public ResponseEntity<Books> addBook(@RequestBody Books books) {
        Books savedBook = bookServiceImpl.postBook(books);
        if (savedBook == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(savedBook);
        }
    }

    @GetMapping("/books")
    public ResponseEntity<List<Books>> getBooks() {
        List<Books> booksList = bookServiceImpl.getAllBook();
        if (booksList == null || booksList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(booksList);
        }
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Books> getbookByIds(@PathVariable("bookId") int id) {
        Optional<Books> bId = bookServiceImpl.getBookById(id);
        if (bId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.ok(bId.get());
        }

    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> delete(@PathVariable("bookId") int id) {
        boolean isDeleted = bookServiceImpl.deleteBook(id);

        if (isDeleted) {

            return ResponseEntity.noContent().build();
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Books> updateBook(@PathVariable("bookId") int id, @RequestBody Books updatedBook) {
        Books book = bookServiceImpl.updateBook(id, updatedBook);

        if (book == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {

            return ResponseEntity.ok(book);
        }
    }
}
