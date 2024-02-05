package it.unical.prontoMiao.persistenza.dao;


import it.unical.prontoMiao.persistenza.model.Utente;

import java.util.Optional;

public interface UtenteDao {

    Optional<Utente> findByEmailIgnoreCase(String email);
}
