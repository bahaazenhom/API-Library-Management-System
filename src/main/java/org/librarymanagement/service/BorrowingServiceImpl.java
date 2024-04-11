package org.librarymanagement.service;

import jakarta.transaction.Transactional;
import org.librarymanagement.dao.BorrowingRepository;
import org.librarymanagement.model.Book;
import org.librarymanagement.service.*;
import org.librarymanagement.model.Borrowing;
import org.librarymanagement.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    private final BorrowingRepository borrowingRepository;
    private final BookService bookService;
    private final PatronService patronService;


    @Autowired
    public BorrowingServiceImpl(BorrowingRepository borrowingRepository, BookService bookService, PatronService patronService) {
        this.borrowingRepository = borrowingRepository;
        this.bookService = bookService;
        this.patronService = patronService;
    }

    @Override
    @Transactional
    public void borrowBook(int bookId, int patronId) {
        Book book = bookService.searchBookById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.getCopiesAvailable() == 0) throw new RuntimeException("No copies available");
        Patron patron = patronService.searchPatronById(patronId).orElseThrow(() -> new RuntimeException("Patron not found"));
        Borrowing borrowing = borrowingRepository.findBorrowingByBookAndPatron(book, patron);
        if (borrowing != null) throw new RuntimeException("Book already borrowed");
        borrowing = new Borrowing(book, patron, false);
        borrowingRepository.save(borrowing);
        book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        bookService.updateBook(bookId, book);
    }
    @Override
    @Transactional
    public void returnBook(int bookId, int patronId) {
        Book book = bookService.searchBookById(bookId).orElseThrow(() -> new RuntimeException("Borrowing not found"));
        Patron patron = patronService.searchPatronById(patronId).orElseThrow(() -> new RuntimeException("Borrowing not found"));
        Borrowing borrowing = borrowingRepository.findBorrowingByBookAndPatron(book, patron);
        if (borrowing == null) throw new RuntimeException("Borrowing not found");
        if (borrowing.getReturnStatus()) throw new RuntimeException("Book already returned");
        borrowing.setReturnStatus(true);
        book.setCopiesAvailable(book.getCopiesAvailable() + 1);
        bookService.updateBook(bookId, book);
    }

}
