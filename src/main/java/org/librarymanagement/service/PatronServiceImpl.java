package org.librarymanagement.service;

import jakarta.transaction.Transactional;
import org.librarymanagement.dao.PatronRepository;
import org.librarymanagement.model.Patron;
import org.librarymanagement.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronServiceImpl implements PatronService{
    private final PatronRepository patronRepository;

    @Autowired
    public PatronServiceImpl(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    @Override
    @Transactional
    public void addPatron(Patron patron) {
        patronRepository.save(patron);
    }

    @Override
    @Transactional
    public void deletePatron(int id) {
        Optional<Patron> patron = patronRepository.findById(id);
        if(!patron.isPresent()){
            throw new RuntimeException("Patron not found");
        }
        patronRepository.delete(patron.get());
    }

    @Override
    @Transactional
    public void updatePatron(int id, Patron patron) {
        Optional<Patron> updatedPatron = patronRepository.findById(id);
        if(!updatedPatron.isPresent()){
            throw new RuntimeException("Patron not found");
        }
        patron.setId(id);
        patronRepository.save(patron);
    }

    @Override
    public Optional<Patron> searchPatronById(int id) {
       return patronRepository.findById(id);
    }

    @Override
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }
}
