package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.Utente;
import it.unical.prontoMiao.repository.UtenteRepository;
import it.unical.prontoMiao.service.AuthenticationService;
import it.unical.prontoMiao.service.JwtService;
import it.unical.prontoMiao.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UtenteRepository utenteRepository;

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public String login(Utente utente) throws IllegalArgumentException{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(utente.getEmail(), utente.getPassword()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        Utente user = utenteRepository.findByEmailIgnoreCase(utente.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Credenziali errate"));
        if(!encoder.matches(utente.getPassword(),user.getPassword())){
            throw new IllegalArgumentException("Credenziali errate");
        }
        String jwt = jwtService.generateToken(user);

        return jwt;
    }

    @Override
    public Utente signup(Utente utente) {
        Utente u = new Utente(utente.getEmail(), encoder.encode(utente.getPassword()));
        return utenteRepository.save(u);
    }
}
