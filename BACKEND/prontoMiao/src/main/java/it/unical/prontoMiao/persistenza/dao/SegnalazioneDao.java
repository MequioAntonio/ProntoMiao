package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.Segnalazione;

import java.io.IOException;
import java.util.List;

public interface SegnalazioneDao {
    public List<Segnalazione> getSegnalazione();
    public Segnalazione getSegnalazioneById(int idSegnalazione);
    public Segnalazione insertSegnalazione(Segnalazione segnalazione) throws IOException;
    public Segnalazione updateSegnalazione(int id, Segnalazione up);
}
