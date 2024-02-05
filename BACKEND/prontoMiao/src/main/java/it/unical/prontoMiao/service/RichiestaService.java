package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model_old.Richiesta;

import org.springframework.data.crossstore.ChangeSetPersister;

import java.io.IOException;
import java.util.List;

public interface RichiestaService {
    public List<Richiesta> getRichiesta();
    public Richiesta getRichiestaById(int idRichiesta) throws ChangeSetPersister.NotFoundException;

    public Richiesta insertRichiesta(Richiesta richiesta) throws IOException;
    public List<Richiesta> getRichiesteByCentro(int idCentro) throws ChangeSetPersister.NotFoundException;
    public List<Richiesta> getRichiesteByUtente(int idUtente) throws ChangeSetPersister.NotFoundException;
    public Richiesta updateRichiesta(int id, Richiesta up);
}
