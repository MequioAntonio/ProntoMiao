package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.UtentePrivato;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UtentePrivatoDao {

    public List<UtentePrivato> findAll() throws SQLException;
    public UtentePrivato findByEmail(String email) throws SQLException;

    public UtentePrivato findById(Integer id) throws SQLException;

    public Optional<UtentePrivato> findByEmailIgnoreCase(String email);

    public UtentePrivato save(UtentePrivato utente) throws SQLException;

    public void deleteById(Integer idUtente) throws SQLException;

}
