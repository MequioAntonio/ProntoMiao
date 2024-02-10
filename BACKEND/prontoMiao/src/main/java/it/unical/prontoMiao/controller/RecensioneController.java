package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.dao.RecensioneDao;
import it.unical.prontoMiao.persistenza.model.Recensione;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/recensione")
public class RecensioneController {


    @GetMapping
    public ResponseEntity getAllRecensioni(){
        RecensioneDao recensioneDao = DBManager.getInstance().getRecensioneDao();
        try {
            return new ResponseEntity<>(recensioneDao.findAll(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{idRecensione}")
    public ResponseEntity getRecensioneById(@PathVariable int idRecensione) {
        RecensioneDao recensioneDao = DBManager.getInstance().getRecensioneDao();
        try {
            return new ResponseEntity<>(recensioneDao.findById(idRecensione), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byCentro/{idCentro}")
    public ResponseEntity getAllRecensioniByCentro(@PathVariable int idCentro){
        RecensioneDao recensioneDao = DBManager.getInstance().getRecensioneDao();
        try {
            return new ResponseEntity<>(recensioneDao.findByCentro(idCentro), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity insertRecensione(@RequestBody Recensione recensione) {
        RecensioneDao recensioneDao = DBManager.getInstance().getRecensioneDao();
        try {
            return new ResponseEntity<>(recensioneDao.save(recensione), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/{idRecensione}")
    public ResponseEntity updateAnnuncio(@PathVariable Integer idRecensione, @RequestBody Recensione recensione) {
        RecensioneDao recensioneDao = DBManager.getInstance().getRecensioneDao();
        try {
            recensione.setId(idRecensione);
            return new ResponseEntity<>(recensioneDao.save(recensione), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{idRecensione}")
    public ResponseEntity deleteRecensioneById(@PathVariable int idRecensione) {
        RecensioneDao recensioneDao = DBManager.getInstance().getRecensioneDao();

        try {
            recensioneDao.delete(idRecensione);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
}
