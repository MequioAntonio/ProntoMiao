package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.Annuncio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AnnuncioDao {
    public List<Annuncio> findAll() throws SQLException;
    public Annuncio findById(Integer idAnnuncio) throws SQLException;
    public Annuncio save(Annuncio annuncio) throws SQLException, IOException;
    public void delete(Integer idAnnuncio) throws SQLException;
    public List<Annuncio> findByCentroId(Integer idCentro) throws SQLException;
    public List<Annuncio> findSenzaRichiestaAccettata() throws SQLException;

}
