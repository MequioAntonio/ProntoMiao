package it.unical.prontoMiao.persistenza.dao;


import it.unical.prontoMiao.persistenza.model.Utente;

import java.sql.SQLException;
import java.util.Optional;

public interface UtenteDao {

    public Optional<Utente> findByEmailIgnoreCase(String email) throws SQLException;
}
