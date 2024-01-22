package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model.Animale;
import it.unical.prontoMiao.service.AnimaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/animale")
public class AnimaleController {

    @Autowired
    private AnimaleService animaleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Animale>> getAllAnimali() {
        return new ResponseEntity<List<Animale>>(animaleService.getAnimali(),HttpStatus.OK);
    }

}
