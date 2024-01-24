package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model.UtentePrivato;
import it.unical.prontoMiao.service.UtentePrivatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/utente")
public class UtentePrivatoController {
    @Autowired
    private UtentePrivatoService utentePrivatoService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UtentePrivato>> getAllUtentiPrivati(){
        return new ResponseEntity<List<UtentePrivato>>(utentePrivatoService.getUtentiPrivati(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UtentePrivato> insertUtentePrivato(@RequestBody UtentePrivato up) {
        return new ResponseEntity<UtentePrivato>(utentePrivatoService.insertUtentePrivato(up), HttpStatus.OK);
    }

    @RequestMapping(value= "/{emailUtentePrivato}", method = RequestMethod.POST)
    public ResponseEntity<UtentePrivato> updateUtentePrivato(@PathVariable String email, @RequestBody UtentePrivato up) {
        return new ResponseEntity<UtentePrivato>(utentePrivatoService.updateUtentePrivato(email, up), HttpStatus.OK);
    }

    @RequestMapping(value= "/{emailUtentePrivato}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUtentePrivato(@PathVariable String email) {
        utentePrivatoService.deleteUtentePrivato(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

  /*  @RequestMapping(value= "/utente/{id}", method = RequestMethod.GET)
    public ResponseEntity getUtenteByID(@PathVariable String id) {
        try {
            Optional<UtentePrivato> res = utentePrivatoService.getUtenteByID(id);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity("Nessun utente trovato", HttpStatus.NOT_FOUND);
        }
    } */

    @GetMapping("/utente/{email}")
    public Optional<UtentePrivato> getUserByEmail(@PathVariable String email) throws ChangeSetPersister.NotFoundException {
        return utentePrivatoService.getUtenteByEmail(email);
    }

    @GetMapping("/utente/{id}")
    public Optional<Optional<UtentePrivato>> getUserByID(@PathVariable String id) throws ChangeSetPersister.NotFoundException {
        return utentePrivatoService.getUtenteByID(id);
    }

}
