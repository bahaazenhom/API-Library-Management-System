package org.librarymanagement.controllers;

import org.librarymanagement.model.Patron;
import org.librarymanagement.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api")
public class PatronRestController {
    private final PatronService patronService;
    @Autowired
    public PatronRestController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping("/patrons")
    public List<Patron> getPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/patrons/{id}")
    public Optional<Patron> getPatronById(@PathVariable int id) {
        return patronService.searchPatronById(id);
    }

    @PostMapping("/patrons")
    public ResponseEntity<Patron> addPatron(@RequestBody Patron patron) {
        patronService.addPatron(patron);
        return ResponseEntity.ok(patron);
    }
    @PutMapping("/patrons/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable int id,@RequestBody Patron patron) {
        patronService.updatePatron(id,patron);
        return ResponseEntity.ok(patron);
    }
    @DeleteMapping("/patrons/{id}")
    public void deletePatron(@PathVariable int id) {
        patronService.deletePatron(id);
    }


}
