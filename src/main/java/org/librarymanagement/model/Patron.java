package org.librarymanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
public class Patron {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    @NotNull@NotBlank
    private String name;
    @Basic
    @Column(name = "address")
    @NotBlank
    private String address;
    @Basic
    @Column(name = "email")
    @Email
    private String email;
    @Basic
    @Column(name = "phone_number")
    @NotBlank
    private String phoneNumber;
    @OneToMany(mappedBy = "patron")
    private List<Borrowing> borrowings;

    public Patron() {
    }

    public Patron(String name, String address, String email, String phoneNumber, List<Borrowing> borrowings) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowings = borrowings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Borrowing> getBorrowingRecords() {
        return borrowings;
    }

    public void setBorrowingRecords(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", borrowingRecords=" + borrowings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patron patron = (Patron) o;
        return id == patron.id && Objects.equals(name, patron.name) && Objects.equals(address, patron.address) && Objects.equals(email, patron.email) && Objects.equals(phoneNumber, patron.phoneNumber) && Objects.equals(borrowings, patron.borrowings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, email, phoneNumber, borrowings);
    }
}
