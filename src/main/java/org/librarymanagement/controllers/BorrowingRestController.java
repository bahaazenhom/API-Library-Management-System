package org.librarymanagement.controllers;

import org.librarymanagement.service.BookService;
import org.librarymanagement.service.BorrowingService;
import org.librarymanagement.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BorrowingRestController {
    private final BorrowingService borrowingService;
    private final BookService bookService;
    private final PatronService patronService;

    @Autowired
    public BorrowingRestController(BorrowingService borrowingService, BookService bookService, PatronService patronService) {
        this.borrowingService = borrowingService;
        this.bookService = bookService;
        this.patronService = patronService;
    }

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public void borrowBook(@PathVariable int bookId, @PathVariable int patronId) {
        borrowingService.borrowBook(bookId, patronId);
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public void returnBook(@PathVariable int bookId, @PathVariable int patronId) {
        borrowingService.returnBook(bookId, patronId);
    }

}
