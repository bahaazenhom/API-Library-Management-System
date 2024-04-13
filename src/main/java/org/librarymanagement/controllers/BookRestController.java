package org.librarymanagement.controllers;

import jakarta.validation.Valid;
import org.librarymanagement.model.Book;
import org.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api")
public class BookRestController {
    private final BookService bookService;
    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
      //  System.out.println(bookService.getAllBooks());
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable int id) {
        return bookService.searchBookById(id);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody@Valid Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok(book);
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,@RequestBody Book book) {
        bookService.updateBook(id,book);
        return ResponseEntity.ok(book);
    }
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }


}
