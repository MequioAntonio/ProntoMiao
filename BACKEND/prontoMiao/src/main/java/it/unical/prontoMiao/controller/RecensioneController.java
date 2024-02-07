package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model_old.Recensione;
import it.unical.prontoMiao.service.RecensioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/recensione")
public class RecensioneController {
    @Autowired
    private RecensioneService recensioneService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Recensione>> getAllRecensioni(){
        return new ResponseEntity<>(recensioneService.getRecensione(), HttpStatus.OK);
    }
    @RequestMapping(value= "/{idRecensione}", method = RequestMethod.GET)
    public ResponseEntity getRecensioneById(@PathVariable int idRecensione) {
        try {
            Recensione res = recensioneService.getRecensioneById(idRecensione);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity("Nessuna recensione trovata", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value= "/byCentro/{idCentro}", method = RequestMethod.GET)
    public ResponseEntity<List<Recensione>> getAllRecensioniByCentro(@PathVariable int idCentro){
        try {
            return new ResponseEntity<List<Recensione>>(recensioneService.getRecensioniByCentro(idCentro), HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity("Nessuna recensione trovata", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Recensione> insertRecensione(@RequestBody Recensione recensione) {
        try {
            return new ResponseEntity<>(recensioneService.insertRecensione(recensione), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity("Errore nel salvataggio del file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{idRecensione}")
    public ResponseEntity deleteRecensioneById(@PathVariable int idRecensione) {
        recensioneService.deleteRecensioneById(idRecensione);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
