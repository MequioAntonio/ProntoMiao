package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.UtentePrivato;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UtentePrivatoDao {

    List<UtentePrivato> findAll() throws SQLException;
    UtentePrivato findByEmail(String email) throws SQLException;

    UtentePrivato findById(Integer id) throws SQLException;

    Optional<UtentePrivato> findByEmailIgnoreCase(String email);

    UtentePrivato save(UtentePrivato utente) throws SQLException;

    void delete(Integer idUtente) throws SQLException;

}
