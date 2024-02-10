package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.Segnalazione;

import java.sql.SQLException;
import java.util.List;

public interface SegnalazioneDao {
    public List<Segnalazione> findAll() throws SQLException;
    public Segnalazione findById(Integer idSegnalazione) throws SQLException;
    public Segnalazione save(Segnalazione segnalazione) throws SQLException;
    public void delete(Integer id) throws SQLException;


}
