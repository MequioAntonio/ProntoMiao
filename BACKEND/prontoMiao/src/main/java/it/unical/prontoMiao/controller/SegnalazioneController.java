package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model_old.Segnalazione;
import it.unical.prontoMiao.service.SegnalazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/segnalazione")
public class SegnalazioneController {
    @Autowired
    private SegnalazioneService segnalazioneService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Segnalazione>> getAllSegnalazioni(){
        return new ResponseEntity<List<Segnalazione>>(segnalazioneService.getSegnalazione(), HttpStatus.OK);
    }
    @RequestMapping(value= "/{idSegnalazione}", method = RequestMethod.GET)
    public ResponseEntity getSegnalazioneById(@PathVariable int idSegnalazione) {
        try {
            Segnalazione res = segnalazioneService.getSegnalazioneById(idSegnalazione);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity("Nessuna segnalazione trovato", HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Segnalazione> insertSegnalazione(@RequestBody Segnalazione segnalazione) {
        try {
            return new ResponseEntity<>(segnalazioneService.insertSegnalazione(segnalazione), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity("Errore nel salvataggio della segnalazione", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value= "/{id}", method = RequestMethod.POST)
    public ResponseEntity<Segnalazione> updateSegnalazione(@PathVariable int id, @RequestBody Segnalazione up) {
        return new ResponseEntity<Segnalazione>(segnalazioneService.updateSegnalazione(id, up), HttpStatus.OK);
    }
}
