package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model.Utente;

public interface AuthenticationService {
    public String login(Utente utente) throws IllegalArgumentException;

    public Utente signup(Utente utente);
}

