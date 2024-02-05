package it.unical.prontoMiao.persistenza.dao;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.repository.Query;

import it.unical.prontoMiao.persistenza.model.Annuncio;

public interface AnnuncioDao {
    public List<Annuncio> getAnnunci();
    public Annuncio getAnnuncioById(int idAnnuncio);

    public void insertAnnuncio(Annuncio annuncio);
    public List<Annuncio> getAnnunciByCentro(int idCentro);

    // public List<Annuncio> getAnnunciNotRichiestaAccettata();

    // Optional<Annuncio> findById(int idAnnuncio);
    // List<Annuncio> findByCentro_Id(int idCentro);

    public List<Annuncio> findAllNotInRichiestaAccettata();
}
