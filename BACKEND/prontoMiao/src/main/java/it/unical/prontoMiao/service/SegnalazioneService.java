package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.model.Segnalazione;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.io.IOException;
import java.util.List;

public interface SegnalazioneService {
    public List<Segnalazione> getSegnalazione();
    public Segnalazione getSegnalazioneById(int idSegnalazione) throws ChangeSetPersister.NotFoundException;
    public Segnalazione insertSegnalazione(Segnalazione segnalazione) throws IOException;
}
