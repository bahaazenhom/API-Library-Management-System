# API Library Management System

## Overview

The API Library Management System is a Java-based application designed to manage a library's resources, including books, patrons, borrowings, and employees. This system provides a set of RESTful API endpoints for performing CRUD operations on various entities and implements role-based access control for secure access to resources.

## Running the Application

1. Clone the project from the GitHub repository.
2. Navigate to the project directory.
3. Ensure you have Java and Maven installed on your system.
4. Build the project using Maven:
    ```bash
    mvn clean install
    ```
5. Once the build is successful, run the application:
    ```bash
    java -jar target/api-library-management-system.jar
    ```
6. The application should now be running locally on port 8080.

## Interacting with API Endpoints

### Book Management Endpoints

- **Retrieve all books:** `GET /api/books`
- **Retrieve a specific book:** `GET /api/books/{id}`
- **Add a new book:** `POST /api/books`
- **Update an existing book:** `PUT /api/books/{id}`
- **Remove a book:** `DELETE /api/books/{id}`

### Patron Management Endpoints

- **Retrieve all patrons:** `GET /api/patrons`
- **Retrieve a specific patron:** `GET /api/patrons/{id}`
- **Add a new patron:** `POST /api/patrons`
- **Update an existing patron:** `PUT /api/patrons/{id}`
- **Remove a patron:** `DELETE /api/patrons/{id}`

### Borrowing Endpoints

- **Borrow a book:** `POST /api/borrow/{bookId}/patron/{patronId}`
- **Return a borrowed book:** `PUT /api/return/{bookId}/patron/{patronId}`
  
### Employee Endpoints

- **Retrieve all employees:** `GET /api/employees`
  - Retrieves a list of all employees in the system.

- **Retrieve details of a specific employee:** `GET /api/employees/{id}`
  - Retrieves details of a specific employee by their ID.

- **Add a new employee:** `POST /api/employees`
  - Adds a new employee to the system.

- **Update an existing employee's information:** `PUT /api/employees/{id}`
  - Updates the information of an existing employee identified by their ID.

- **Remove an employee:** `DELETE /api/employees/{id}`
  - Removes an employee from the system based on their ID.



## Authentication

The API Library Management System implements role-based access control:
- **Admin:** Full access to all endpoints.
- **Librarian:** Access to book and patron management endpoints.
- **Manager:** Access to book and patron management endpoints, as well as borrowing management.
- **Employee:** No access to management endpoints, only borrowing and returning books.

To authenticate, include the appropriate role in the request headers.
