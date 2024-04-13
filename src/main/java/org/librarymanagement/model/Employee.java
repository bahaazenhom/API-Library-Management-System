package org.librarymanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

import java.util.Objects;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    @NotBlank@NotBlank
    private String name;
    @Basic
    @Column(name = "user_name")
    @NotNull@NotBlank
    private String userName;

    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "email")
    @Email
    private String email;
    @Basic
    @Column(name = "phone_number")
    @NumberFormat
    private String phoneNumber;

    @Basic
    @Column(name = "password")
    @NotNull@NotBlank
    private String password;

    @Basic
    @Column(name = "role")
    @NotNull@NotBlank
    private String role;
    @Basic
    @Column(name = "enabled")
    @NotNull
    private Boolean enabled;


    public Employee() {
    }

    public Employee(String name, String userName, String address, String email, String phoneNumber, String password, String role, Boolean enabled) {
        this.name = name;
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(userName, employee.userName) && Objects.equals(address, employee.address) && Objects.equals(email, employee.email) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(password, employee.password) && Objects.equals(role, employee.role) && Objects.equals(enabled, employee.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userName, address, email, phoneNumber, password, role, enabled);
    }
}
