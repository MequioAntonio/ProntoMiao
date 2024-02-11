package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.dao.SegnalazioneDao;
import it.unical.prontoMiao.persistenza.model.Segnalazione;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4210", "http://localhost:4220"})
@RequestMapping(value = "/segnalazione")
public class SegnalazioneController {

    @GetMapping
    public ResponseEntity getAllSegnalazioni(){
        SegnalazioneDao segnalazioneDao = DBManager.getInstance().getSegnalazioneDao();
        try {
            return new ResponseEntity<>(segnalazioneDao.findAll(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{idSegnalazione}")
    public ResponseEntity getSegnalazioneById(@PathVariable int idSegnalazione) {
        SegnalazioneDao segnalazioneDao = DBManager.getInstance().getSegnalazioneDao();
        try {
            return new ResponseEntity<>(segnalazioneDao.findById(idSegnalazione), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity insertSegnalazione(@RequestBody Segnalazione segnalazione) {
        SegnalazioneDao segnalazioneDao = DBManager.getInstance().getSegnalazioneDao();
        try {
            return new ResponseEntity<>(segnalazioneDao.save(segnalazione), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{idSegnalazione}")
    public ResponseEntity updateSegnalazione(@PathVariable Integer idSegnalazione, @RequestBody Segnalazione segnalazione) {
        SegnalazioneDao segnalazioneDao = DBManager.getInstance().getSegnalazioneDao();
        try {
            segnalazione.setId(idSegnalazione);
            return new ResponseEntity<>(segnalazioneDao.save(segnalazione), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idSegnalazione}")
    public ResponseEntity deleteSegnalazione(@PathVariable Integer idSegnalazione) {
        SegnalazioneDao segnalazioneDao = DBManager.getInstance().getSegnalazioneDao();
        try {
            segnalazioneDao.delete(idSegnalazione);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
