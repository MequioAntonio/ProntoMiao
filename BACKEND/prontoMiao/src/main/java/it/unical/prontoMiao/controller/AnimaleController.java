package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model_old.Animale;
import it.unical.prontoMiao.service.AnimaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/animale")
public class AnimaleController {

    @Autowired
    private AnimaleService animaleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Animale>> getAllAnimali(@Nullable @Param(value = "nome") String nome, @Nullable @Param(value = "eta") Integer eta, @Nullable @Param(value = "razza") String razza, @Nullable @Param(value = "taglia") String taglia) {
        return new ResponseEntity<List<Animale>>(animaleService.getAnimali(nome, razza, taglia),HttpStatus.OK);
    }
    @RequestMapping(value = "/notAnnuncio",method = RequestMethod.GET)
    public ResponseEntity<List<Animale>> getAllAnimaliNotAnnuncio() {
        return new ResponseEntity<List<Animale>>(animaleService.getAnimaliSenzaAnnuncio(),HttpStatus.OK);
    }
    @RequestMapping(value = "/byNome",method = RequestMethod.GET)
    public ResponseEntity<List<Animale>> getAllAnimaliByNome(@Param(value = "nome") String nome) {
        return new ResponseEntity<List<Animale>>(animaleService.getAnimaleByNome(nome),HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Animale> insertAnimale(@RequestBody Animale animale) {
        return new ResponseEntity<Animale>(animaleService.insertAnimale(animale), HttpStatus.OK);
    }
    @RequestMapping(value= "/{idAnimale}", method = RequestMethod.POST)
    public ResponseEntity<Animale> updateAnimale(@PathVariable int idAnimale, @RequestBody Animale animale) {
        return new ResponseEntity<Animale>(animaleService.updateAnimale(idAnimale, animale), HttpStatus.OK);
    }
    @RequestMapping(value= "/{idAnimale}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAnimale(@PathVariable int idAnimale) {
        animaleService.deleteAnimale(idAnimale);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value= "/{idAnimale}", method = RequestMethod.GET)
    public ResponseEntity getAnimaleById(@PathVariable int idAnimale) {
        try {
            Animale res = animaleService.getAnimaleById(idAnimale);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity("Nessun animale trovato", HttpStatus.NOT_FOUND);
        }
    }
}
