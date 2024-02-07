package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.Segnalazione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface SegnalazioneDao {
    public List<Segnalazione> findAll();
    public Segnalazione findById(Integer idSegnalazione);
    public Segnalazione save(Segnalazione segnalazione) throws SQLException;
    public void delete(Integer id) throws SQLException;


}
