package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.dao.CentroAdozioniDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/centro-adozioni")
public class CentroAdozioniController {

    @GetMapping
    public ResponseEntity getAllCentriAdozioni(){
        CentroAdozioniDao centroAdozioniDao = DBManager.getInstance().getCentroAdozioniDao();
        try {
            return new ResponseEntity<>(centroAdozioniDao.findAllLazy(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getCenterByID(@PathVariable int id)  {
        CentroAdozioniDao centroAdozioniDao = DBManager.getInstance().getCentroAdozioniDao();
        try {
            return new ResponseEntity<>(centroAdozioniDao.findById(id), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
