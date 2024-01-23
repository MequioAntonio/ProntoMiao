package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model.Annuncio;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface AnnuncioService {
    public List<Annuncio> getAnnunci();
    public Annuncio getAnnuncioById(int idAnnuncio) throws ChangeSetPersister.NotFoundException;

   // public List<Annuncio> getAnnunciByCentro(String email) throws ChangeSetPersister.NotFoundException;
}
