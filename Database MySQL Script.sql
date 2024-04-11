-- Create the book table
CREATE TABLE book (
  id BIGINT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  publication_year INT DEFAULT NULL,
  isbn VARCHAR(50) DEFAULT NULL,
  genre VARCHAR(50) DEFAULT NULL,
  copies_available INT DEFAULT 0,
  PRIMARY KEY (id)
);

-- Create the patron table
CREATE TABLE patron (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) DEFAULT NULL,
  email VARCHAR(255) DEFAULT NULL,
  phone_number VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (id)
);

-- Create the borrowing table
CREATE TABLE borrowing (
  id INT NOT NULL AUTO_INCREMENT,
  book_id BIGINT DEFAULT NULL,
  patron_id BIGINT DEFAULT NULL,
  return_status TINYINT(1) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY borrowing_book_id_fk (book_id),
  KEY borrowing_patron_id_fk (patron_id),
  CONSTRAINT borrowing_book_id_fk FOREIGN KEY (book_id) REFERENCES book (id) ON UPDATE CASCADE ON DELETE NO ACTION,
  CONSTRAINT borrowing_patron_id_fk FOREIGN KEY (patron_id) REFERENCES patron (id) ON UPDATE CASCADE ON DELETE NO ACTION
);

-- Create the employee table
CREATE TABLE employee (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) DEFAULT NULL,
  email VARCHAR(255) DEFAULT NULL,
  phone_number VARCHAR(20) DEFAULT NULL,
  role VARCHAR(50) NOT NULL,
  user_name VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  enabled BOOLEAN DEFAULT TRUE,
  PRIMARY KEY (id)
);
