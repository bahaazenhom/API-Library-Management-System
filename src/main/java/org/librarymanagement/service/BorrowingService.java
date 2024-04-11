package org.librarymanagement.service;

import org.librarymanagement.model.Book;
import org.librarymanagement.model.Borrowing;
import org.librarymanagement.model.Patron;

public interface BorrowingService {
    public void borrowBook(int bookId, int patronId);
    public void returnBook(int bookId, int patronId);
}
