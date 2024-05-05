package com.example.obliggdkjent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private JdbcTemplate db;
    private Logger logger = LoggerFactory.getLogger(Controller.class);
    @PostMapping("/registrerBillett")
    public ResponseEntity<String> registrerBillett(@RequestBody Billett billett) {
        String sql = "insert into Billett (fornavn, etternavn, telefon, epost) values (?,?,?,?)";
        try {
            db.update(sql, billett.getFornavn(), billett.getEtternavn(), billett.getTlf(), billett.getEpost());
            return ResponseEntity.ok("Billett registrert");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Feil ved registrering av billett");
        }
    }

    @GetMapping("/hentAlleBilletter")
    public ResponseEntity<List<Billett>> hentAlleBilletter() {
        String sql = "SELECT * FROM Billett";
        List<Billett> billetter = db.query(sql, BeanPropertyRowMapper.newInstance(Billett.class));
        if (billetter.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(billetter);
        }
    }


    @DeleteMapping("/slettAlleBilletter")
    public ResponseEntity<String> slettAlleBilletter() {
        String sql = "delete from Billett";
        try {
            db.update(sql);
            return ResponseEntity.ok("Alle billetter slettet");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Feil ved sletting av alle billetter");
        }
    }
}
