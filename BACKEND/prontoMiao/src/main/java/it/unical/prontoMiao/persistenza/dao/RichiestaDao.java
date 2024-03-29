package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.Richiesta;

import java.sql.SQLException;
import java.util.List;


public interface RichiestaDao {
    public List<Richiesta> findAll() throws SQLException;
    public Richiesta findById(Integer idRichiesta) throws SQLException;
    public List<Richiesta> findByAnnuncioCentro(int idCentro) throws SQLException;
    public List<Richiesta> findByUtente(int idUtente) throws SQLException;
    public Richiesta save(Richiesta richiesta) throws SQLException;
    public void delete(Integer idRichiesta) throws SQLException;


}
