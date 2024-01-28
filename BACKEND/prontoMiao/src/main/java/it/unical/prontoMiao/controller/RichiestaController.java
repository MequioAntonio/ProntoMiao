package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.model.Recensione;
import it.unical.prontoMiao.model.Richiesta;
import it.unical.prontoMiao.service.AnnuncioService;
import it.unical.prontoMiao.service.RichiestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/richiesta")
public class RichiestaController {
    @Autowired
    private RichiestaService richiestaService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Richiesta>> getAllRichieste(){
        return new ResponseEntity<List<Richiesta>>(richiestaService.getRichiesta(), HttpStatus.OK);
    }
    @RequestMapping(value= "/{idRichiesta}", method = RequestMethod.GET)
    public ResponseEntity getRichiestaById(@PathVariable int idRichiesta) {
        try {
            Richiesta res = richiestaService.getRichiestaById(idRichiesta);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity("Nessuna richiesta trovata", HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Richiesta> insertRichiesta(@RequestBody Richiesta richiesta) {
        try {
            return new ResponseEntity<>(richiestaService.insertRichiesta(richiesta), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity("Errore nel salvataggio della richiesta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value= "/byCentro/{idCentro}", method = RequestMethod.GET)
    public ResponseEntity<List<Richiesta>> getAllRichiesteByCentro(@PathVariable int idCentro){
        try {
            return new ResponseEntity<List<Richiesta>>(richiestaService.getRichiesteByCentro(idCentro), HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity("Nessuna richiesta trovata", HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value= "/byUtente/{idUtente}", method = RequestMethod.GET)
    public ResponseEntity<List<Richiesta>> getAllRichiesteByUtente(@PathVariable int idUtente){
        try {
            return new ResponseEntity<List<Richiesta>>(richiestaService.getRichiesteByUtente(idUtente), HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity("Nessuna richiesta trovata", HttpStatus.NOT_FOUND);
        }
    }
}
