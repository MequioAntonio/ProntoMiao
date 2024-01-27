package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model.Animale;
import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.model.UtentePrivato;
import it.unical.prontoMiao.service.AnnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/annuncio")
public class AnnuncioController {
    @Autowired
    private AnnuncioService annuncioService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Annuncio>> getAllAnnunci(){
        return new ResponseEntity<List<Annuncio>>(annuncioService.getAnnunci(), HttpStatus.OK);
    }
    @RequestMapping(value= "/{idAnnuncio}", method = RequestMethod.GET)
    public ResponseEntity getAnnuncioById(@PathVariable int idAnnuncio) {
        try {
            Annuncio res = annuncioService.getAnnuncioById(idAnnuncio);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity("Nessun annuncio trovato", HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Annuncio> insertAnnuncio(@RequestBody Annuncio annuncio) {
        try {
            return new ResponseEntity<>(annuncioService.insertAnnuncio(annuncio), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity("Errore nel salvataggio del file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value= "/byCentro/{idCentro}", method = RequestMethod.GET)
    public ResponseEntity<List<Annuncio>> getAllAnnunciByCentro(@PathVariable int idCentro){
        try {
            return new ResponseEntity<List<Annuncio>>(annuncioService.getAnnunciByCentro(idCentro), HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity("Nessun annuncio trovato", HttpStatus.NOT_FOUND);
        }
    }
}
