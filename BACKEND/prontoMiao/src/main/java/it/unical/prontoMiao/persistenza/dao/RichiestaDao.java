package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.Richiesta;

import java.sql.SQLException;
import java.util.List;


public interface RichiestaDao {
    public List<Richiesta> getRichiesta();
    public Richiesta getRichiestaById(Integer idRichiesta);
    List<Richiesta> findByAnnuncio_Centro_Id(int idCentro);
    List<Richiesta> findByUtente_Id(int idUtente) throws SQLException;
    public Richiesta insertRichieta (Richiesta richiesta);

    public Richiesta updateRichiesta(int id, Richiesta richiesta);
    public void deleteRichiestaById(Integer idRichiesta) throws SQLException;


}
