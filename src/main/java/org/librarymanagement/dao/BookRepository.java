package org.librarymanagement.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Integer> {

}
