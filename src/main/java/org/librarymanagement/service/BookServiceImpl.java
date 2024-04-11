package org.librarymanagement.service;

import jakarta.transaction.Transactional;
import org.librarymanagement.dao.BookRepository;
import org.librarymanagement.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if(!book.isPresent()){
            throw new RuntimeException("Book not found");
        }
        bookRepository.delete(book.get());
    }

    @Override
    @Transactional
    public void updateBook(int id,Book book) {
       Optional<Book> updatedBook = bookRepository.findById(id);
         if(!updatedBook.isPresent()){
             throw new RuntimeException("Book not found");
         }
       book.setId(id);
       bookRepository.save(book);
    }

    @Override
    public Optional<Book> searchBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
