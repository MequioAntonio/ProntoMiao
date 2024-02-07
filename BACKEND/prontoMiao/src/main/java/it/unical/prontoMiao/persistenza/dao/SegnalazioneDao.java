package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.Segnalazione;

import java.io.IOException;
import java.util.List;

public interface SegnalazioneDao {
    public List<Segnalazione> findAll();
    public Segnalazione findById(int idSegnalazione);

    public Segnalazione save(Segnalazione segnalazione) throws IOException;
}
