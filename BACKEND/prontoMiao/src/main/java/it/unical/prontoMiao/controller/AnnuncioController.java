package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model.Animale;
import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.service.AnnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
