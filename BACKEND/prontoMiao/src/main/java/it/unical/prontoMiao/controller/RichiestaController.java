package it.unical.prontoMiao.controller;


import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.dao.RichiestaDao;
import it.unical.prontoMiao.persistenza.model.Richiesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/richiesta")
public class RichiestaController {

    @GetMapping
    public ResponseEntity getAllRichieste(){
        RichiestaDao richiestaDao = DBManager.getInstance().getRichiestaDao();
        try {
            return new ResponseEntity<>(richiestaDao.findAll(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{idRichiesta}")
    public ResponseEntity getRichiestaById(@PathVariable int idRichiesta) {
        RichiestaDao richiestaDao = DBManager.getInstance().getRichiestaDao();
        try {
            return new ResponseEntity<>(richiestaDao.findById(idRichiesta), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity insertRichiesta(@RequestBody Richiesta richiesta) {
        RichiestaDao richiestaDao = DBManager.getInstance().getRichiestaDao();
        try {
            return new ResponseEntity<>(richiestaDao.save(richiesta), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/{idRichiesta}")
    public ResponseEntity updateRichiesta(@PathVariable Integer idRichiesta, @RequestBody Richiesta richiesta) {
        RichiestaDao richiestaDao = DBManager.getInstance().getRichiestaDao();
        try {
            richiesta.setId(idRichiesta);
            return new ResponseEntity<>(richiestaDao.save(richiesta), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/byCentro/{idCentro}")
    public ResponseEntity getAllRichiesteByCentro(@PathVariable int idCentro){
        RichiestaDao richiestaDao = DBManager.getInstance().getRichiestaDao();
        try {
            return new ResponseEntity<>(richiestaDao.findByAnnuncioCentro(idCentro), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/byUtente/{idUtente}")
    public ResponseEntity getAllRichiesteByUtente(@PathVariable int idUtente){
        RichiestaDao richiestaDao = DBManager.getInstance().getRichiestaDao();
        try {
            return new ResponseEntity<>(richiestaDao.findByUtente(idUtente), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRichiesta(@PathVariable int id) {
        RichiestaDao richiestaDao = DBManager.getInstance().getRichiestaDao();
        try {
            richiestaDao.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
