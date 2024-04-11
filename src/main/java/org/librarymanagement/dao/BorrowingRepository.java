package org.librarymanagement.dao;

import org.librarymanagement.model.Book;
import org.librarymanagement.model.Borrowing;
import org.librarymanagement.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing, Integer> {
    public Borrowing findBorrowingByBookAndPatron(Book book, Patron patron);
}
