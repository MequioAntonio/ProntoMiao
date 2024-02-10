package it.unical.prontoMiao.service;

import it.unical.prontoMiao.persistenza.model.Utente;
import it.unical.prontoMiao.request.AuthRequest;
import it.unical.prontoMiao.response.JwtTokenResponse;

import java.sql.SQLException;

public interface AuthenticationService {
    public JwtTokenResponse login(Utente utente) throws IllegalArgumentException, SQLException;

    public Utente signup(AuthRequest utente) throws SQLException;
}

