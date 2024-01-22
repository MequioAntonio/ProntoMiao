package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model.UtentePrivato;
import it.unical.prontoMiao.service.UtentePrivatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/utente")
public class UtentePrivatoController {
    @Autowired
    private UtentePrivatoService utentePrivatoService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UtentePrivato>> getAllCentriAdozioni(){
        return new ResponseEntity<List<UtentePrivato>>(utentePrivatoService.getUtentiPrivati(), HttpStatus.OK);
    }
}
