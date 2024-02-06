package it.unical.prontoMiao.persistenza.dao;



import it.unical.prontoMiao.persistenza.model.CentroAdozioni;

import java.sql.SQLException;
import java.util.Optional;

public interface CentroAdozioniDao {

    public CentroAdozioni findById(int id);

    public Optional<CentroAdozioni> findByEmailIgnoreCase(String email);

    public CentroAdozioni findByEmail(String email) throws SQLException;

    public CentroAdozioni save(CentroAdozioni centro) throws SQLException;

    public void delete(Integer idUtente) throws SQLException;
}
