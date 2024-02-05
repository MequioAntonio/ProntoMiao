package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.UtentePrivato;

import java.util.Optional;

public interface UtentePrivatoDao {

    UtentePrivato findByEmail(String email);

    UtentePrivato findById(int id);

    Optional<UtentePrivato> findByEmailIgnoreCase(String email);

    UtentePrivato save(UtentePrivato utente);

}
