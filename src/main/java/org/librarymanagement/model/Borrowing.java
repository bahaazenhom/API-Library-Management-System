package org.librarymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "borrowing")
public class Borrowing {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JsonIgnore
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JsonIgnore
    @JoinColumn(name = "patron_id")
    private Patron patron;
    @Basic
    @Column(name = "return_status")
    private Boolean returnStatus;

    public Borrowing() {
    }

    public Borrowing(Book book, Patron patron, Boolean returnStatus) {
        this.book = book;
        this.patron = patron;
        this.returnStatus = returnStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Boolean getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Boolean returnStatus) {
        this.returnStatus = returnStatus;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "id=" + id +
                ", book=" + book +
                ", patron=" + patron +
                ", returnStatus=" + returnStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrowing borrowing = (Borrowing) o;
        return id == borrowing.id && Objects.equals(book, borrowing.book) && Objects.equals(patron, borrowing.patron) && Objects.equals(returnStatus, borrowing.returnStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, patron, returnStatus);
    }
}
