package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.Recensione;

import java.sql.SQLException;
import java.util.List;

public interface RecensioneDao {
    public List<Recensione> findAll() throws SQLException;
    public Recensione findById(Integer idRecensione) throws SQLException;
    public List<Recensione> findByCentro(Integer idCentro) throws SQLException;
    public Recensione save(Recensione recensione) throws SQLException;
    public void delete(Integer idRecensione) throws SQLException;
}
