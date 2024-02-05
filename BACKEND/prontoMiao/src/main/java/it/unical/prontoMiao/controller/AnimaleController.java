package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.persistenza.model.Animale;
import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.dao.AnimaleDao;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/animale")
public class AnimaleController {

    @GetMapping
    public ResponseEntity getAllAnimali(@Nullable @Param(value = "nome") String nome,
                                        @Nullable @Param(value = "eta") Integer eta,
                                        @Nullable @Param(value = "razza") String razza,
                                        @Nullable @Param(value = "taglia") String taglia) {
        AnimaleDao animaleDao = DBManager.getInstance().getAnimaleDao();
        try {
            if (nome!=null || eta!=null || razza!=null || taglia!=null ){
                return new ResponseEntity<>(animaleDao.findByAllLikeAsc(nome, eta, razza, taglia), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(animaleDao.findAll(), HttpStatus.OK);
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/notAnnuncio")
    public ResponseEntity getAllAnimaliNotAnnuncio() {
        AnimaleDao animaleDao = DBManager.getInstance().getAnimaleDao();
        try {
            return new ResponseEntity<>(animaleDao.findSenzaAnnuncio(),HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/byNome")
    public ResponseEntity getAllAnimaliByNome(@Param(value = "nome") String nome) {
        AnimaleDao animaleDao = DBManager.getInstance().getAnimaleDao();
        try {
            return new ResponseEntity<>(animaleDao.findByNome(nome),HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity insertAnimale(@RequestBody Animale animale) {
        AnimaleDao animaleDao = DBManager.getInstance().getAnimaleDao();
        try {
            return new ResponseEntity<>(animaleDao.saveOrUpdate(animale), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/{idAnimale}")
    public ResponseEntity updateAnimale(@PathVariable Integer idAnimale, @RequestBody Animale animale) {
        AnimaleDao animaleDao = DBManager.getInstance().getAnimaleDao();
        animale.setId(idAnimale);
        try {
            return new ResponseEntity<>(animaleDao.saveOrUpdate(animale), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{idAnimale}")
    public ResponseEntity deleteAnimale(@PathVariable Integer idAnimale) {
        try {
            AnimaleDao animaleDao = DBManager.getInstance().getAnimaleDao();
            animaleDao.delete(idAnimale);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{idAnimale}")
    public ResponseEntity getAnimaleById(@PathVariable Integer idAnimale) {
        try {
            AnimaleDao animaleDao = DBManager.getInstance().getAnimaleDao();
            Animale res = animaleDao.findById(idAnimale);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
