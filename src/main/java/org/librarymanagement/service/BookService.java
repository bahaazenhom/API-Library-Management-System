package org.librarymanagement.service;

import org.librarymanagement.model.Book;

import java.util.*;

public interface BookService {
    public void addBook(Book book);
    public void deleteBook(int id);
    public void updateBook(int id,Book book);
    public Optional<Book> searchBookById(int id);
    public List<Book> getAllBooks();
}
