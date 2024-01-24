package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model.Annuncio;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.io.IOException;
import java.util.List;

public interface AnnuncioService {
    public List<Annuncio> getAnnunci();
    public Annuncio getAnnuncioById(int idAnnuncio) throws ChangeSetPersister.NotFoundException;

    public Annuncio insertAnnuncio(Annuncio annuncio) throws IOException;
   // public List<Annuncio> getAnnunciByCentro(String email) throws ChangeSetPersister.NotFoundException;
}
