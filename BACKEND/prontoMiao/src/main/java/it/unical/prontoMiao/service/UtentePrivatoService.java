package it.unical.prontoMiao.service;

import it.unical.prontoMiao.persistenza.model.UtentePrivato;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UtentePrivatoService {
    public List<UtentePrivato> getUtentiPrivati() throws SQLException;

    public Optional<UtentePrivato> getUtenteByEmail(String email) throws ChangeSetPersister.NotFoundException, SQLException;

    public Optional<UtentePrivato> getUtenteByID(int id) throws ChangeSetPersister.NotFoundException, SQLException;

    public UtentePrivato insertUtentePrivato(UtentePrivato up) throws SQLException;
    public UtentePrivato updateUtentePrivato(int id, UtentePrivato up) throws SQLException;
    public void deleteUtentePrivato(int id) throws SQLException;
    public UtentePrivato loadUserByUsername(String email) throws SQLException;

}
