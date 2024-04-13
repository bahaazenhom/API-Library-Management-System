package org.librarymanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.*;

@Entity
@Table(name = "book")
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "title")
    @NotNull@NotBlank
    private String title;
    @Basic
    @Column(name = "author")
    @NotNull@NotBlank
    private String author;
    @Basic
    @Column(name = "publication_year")
    @Min(1900)
    @Max(2024)
    private Integer publicationYear;
    @Basic
    @Column(name = "isbn")
    @NotNull
    @NotBlank
    private String isbn;
    @Basic
    @Column(name = "genre")
    private String genre;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "book",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Borrowing> borrowings;
    @Basic
    @Column(name = "copies_available")
    @Min(0)@Max(100)
    private int copiesAvailable;


    public Book() {
    }

    public Book(String title, String author, Integer publicationYear, String isbn, String genre, List<Borrowing> borrowings, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.genre = genre;
        this.borrowings = borrowings;
        this.copiesAvailable = copiesAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", borrowings=" + borrowings +
                ", copiesAvailable=" + copiesAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && copiesAvailable == book.copiesAvailable && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publicationYear, book.publicationYear) && Objects.equals(isbn, book.isbn) && Objects.equals(genre, book.genre) && Objects.equals(borrowings, book.borrowings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, publicationYear, isbn, genre, borrowings, copiesAvailable);
    }
}
