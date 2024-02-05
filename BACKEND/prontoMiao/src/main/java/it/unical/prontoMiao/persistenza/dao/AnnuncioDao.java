package it.unical.prontoMiao.persistenza.dao;

import java.sql.SQLException;
import java.util.List;

import it.unical.prontoMiao.persistenza.model.Annuncio;

public interface AnnuncioDao {
    public List<Annuncio> findAll() throws SQLException;
    public Annuncio findById(Integer idAnnuncio) throws SQLException;
    public Annuncio saveOrUpdate(Annuncio annuncio) throws SQLException;
    public void delete(Integer idAnnuncio) throws SQLException;
    public List<Annuncio> findByCentroId(Integer idCentro) throws SQLException;
    public List<Annuncio> findSenzaRichiestaAccettata() throws SQLException;

}
