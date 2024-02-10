package it.unical.prontoMiao.controller;


import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.dao.AnnuncioDao;
import it.unical.prontoMiao.persistenza.model.Annuncio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/annuncio")
public class AnnuncioController {

    @GetMapping
    public ResponseEntity getAllAnnunci(){
        AnnuncioDao annuncioDao = DBManager.getInstance().getAnnuncioDao();
        try {
            return new ResponseEntity<>(annuncioDao.findAll(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/nonAccettati")
    public ResponseEntity getAllAnnunciNonAccettati(){
        AnnuncioDao annuncioDao = DBManager.getInstance().getAnnuncioDao();
        try {
            return new ResponseEntity<>(annuncioDao.findSenzaRichiestaAccettata(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{idAnnuncio}")
    public ResponseEntity getAnnuncioById(@PathVariable Integer idAnnuncio) {
        AnnuncioDao annuncioDao = DBManager.getInstance().getAnnuncioDao();
        try {
            return new ResponseEntity<>(annuncioDao.findById(idAnnuncio), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity insertAnnuncio(@RequestBody Annuncio annuncio) {
        AnnuncioDao annuncioDao = DBManager.getInstance().getAnnuncioDao();
        try {
            return new ResponseEntity<>(annuncioDao.save(annuncio), HttpStatus.OK);
        } catch (SQLException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{idAnnuncio}")
    public ResponseEntity updateAnnuncio(@PathVariable Integer idAnnuncio, @RequestBody Annuncio annuncio) {
        AnnuncioDao annuncioDao = DBManager.getInstance().getAnnuncioDao();
        annuncio.setId(idAnnuncio);
        try {
            return new ResponseEntity<>(annuncioDao.save(annuncio), HttpStatus.OK);
        } catch (SQLException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idAnnuncio}")
    public ResponseEntity deleteAnnuncio(@PathVariable Integer idAnnuncio) {
        AnnuncioDao annuncioDao = DBManager.getInstance().getAnnuncioDao();
        try {
            annuncioDao.delete(idAnnuncio);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byCentro/{idCentro}")
    public ResponseEntity getAllAnnunciByCentro(@PathVariable int idCentro){
        AnnuncioDao annuncioDao = DBManager.getInstance().getAnnuncioDao();
        try {
            return new ResponseEntity<>(annuncioDao.findByCentroId(idCentro),HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
