package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model_old.Recensione;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.io.IOException;
import java.util.List;

public interface RecensioneService {
    public List<Recensione> getRecensione();
    public Recensione getRecensioneById(int idRecensione) throws ChangeSetPersister.NotFoundException;
    public List<Recensione> getRecensioniByCentro(int idCentro) throws ChangeSetPersister.NotFoundException;
    public Recensione insertRecensione(Recensione recensione) throws IOException;
    public void deleteRecensioneById(int idRecensione);
}
