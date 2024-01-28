package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model.Utente;
import it.unical.prontoMiao.request.AuthRequest;
import it.unical.prontoMiao.response.JwtTokenResponse;

public interface AuthenticationService {
    public JwtTokenResponse login(Utente utente) throws IllegalArgumentException;

    public Utente signup(AuthRequest utente);
}

