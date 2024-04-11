package org.librarymanagement.service;

import org.librarymanagement.model.Patron;
import org.librarymanagement.model.Patron;
import java.util.*;
public interface PatronService {
    public void addPatron(Patron patron);
    public void deletePatron(int id);
    public void updatePatron(int id,Patron patron);
    public Optional<Patron> searchPatronById(int id);
    public List<Patron> getAllPatrons();
}
