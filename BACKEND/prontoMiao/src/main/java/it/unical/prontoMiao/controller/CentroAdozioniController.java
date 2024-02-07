package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model_old.CentroAdozioni;
import it.unical.prontoMiao.service.CentroAdozioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/centro-adozioni")
public class CentroAdozioniController {
    @Autowired
    private CentroAdozioniService centroAdozioniService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CentroAdozioni>> getAllCentriAdozioni(){
        return new ResponseEntity<List<CentroAdozioni>>(centroAdozioniService.getCentriAdozione(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<CentroAdozioni> getCenterByID(@PathVariable int id) throws ChangeSetPersister.NotFoundException {
        return centroAdozioniService.getCentroByID(id);
    }
}
