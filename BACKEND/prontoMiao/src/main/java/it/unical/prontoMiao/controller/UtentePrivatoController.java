package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.dao.UtentePrivatoDao;
import it.unical.prontoMiao.persistenza.model.UtentePrivato;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4210", "http://localhost:4220"})
@RequestMapping(value = "/utente")
public class UtentePrivatoController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllUtentiPrivati(){
        UtentePrivatoDao utentePrivatoDao = DBManager.getInstance().getUtentePrivatoDao();
        try {
            return new ResponseEntity<>(utentePrivatoDao.findAll(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity insertUtentePrivato(@RequestBody UtentePrivato up) {
        UtentePrivatoDao utentePrivatoDao = DBManager.getInstance().getUtentePrivatoDao();
        try {
            return new ResponseEntity<>(utentePrivatoDao.save(up), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.POST)
    public ResponseEntity updateUtentePrivato(@PathVariable int id, @RequestBody UtentePrivato up) {
        UtentePrivatoDao utentePrivatoDao = DBManager.getInstance().getUtentePrivatoDao();
        up.setId(id);
        try {
            return new ResponseEntity<>(utentePrivatoDao.save(up), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUtentePrivato(@PathVariable int id) {
        UtentePrivatoDao utentePrivatoDao = DBManager.getInstance().getUtentePrivatoDao();
        try {
            utentePrivatoDao.deleteById(id);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byEmail/{email}")
    public Optional<UtentePrivato> getUserByEmail(@PathVariable String email) throws ChangeSetPersister.NotFoundException {

        UtentePrivatoDao utentePrivatoDao = DBManager.getInstance().getUtentePrivatoDao();

        return utentePrivatoDao.findByEmailIgnoreCase(email);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserByID(@PathVariable int id) throws ChangeSetPersister.NotFoundException {
        UtentePrivatoDao utentePrivatoDao = DBManager.getInstance().getUtentePrivatoDao();
        try {
            return new ResponseEntity<>(utentePrivatoDao.findById(id), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
