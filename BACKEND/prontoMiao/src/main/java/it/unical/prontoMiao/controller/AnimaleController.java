package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model.Animale;
import it.unical.prontoMiao.service.AnimaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<Animale>> getAllAnimali(@Nullable @Param(value = "nome") String nome, @Nullable @Param(value = "eta") Integer eta, @Nullable @Param(value = "razza") String razza, @Nullable @Param(value = "taglia") String taglia) {
        return new ResponseEntity<List<Animale>>(animaleService.getAnimali(nome, razza, taglia),HttpStatus.OK);
    }
    @RequestMapping(value = "/byNome",method = RequestMethod.GET)
    public ResponseEntity<List<Animale>> getAllAnimaliByNome(@Param(value = "nome") String nome) {
        return new ResponseEntity<List<Animale>>(animaleService.getAnimaleByNome(nome),HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Animale> insertAnimale(@RequestBody Animale animale) {
        return new ResponseEntity<Animale>(animaleService.insertAnimale(animale), HttpStatus.OK);
    }

}
