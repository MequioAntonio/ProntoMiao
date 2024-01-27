package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.CentroAdozioni;
import it.unical.prontoMiao.model.Utente;
import it.unical.prontoMiao.model.UtentePrivato;
import it.unical.prontoMiao.repository.CentroAdozioniRepository;
import it.unical.prontoMiao.repository.UtentePrivatoRepository;
import it.unical.prontoMiao.repository.UtenteRepository;
import it.unical.prontoMiao.request.AuthRequest;
import it.unical.prontoMiao.response.JwtTokenResponse;
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
    UtentePrivatoRepository utentePrivatoRepository;
    @Autowired
    CentroAdozioniRepository centroAdozioniRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public JwtTokenResponse login(Utente utente) throws IllegalArgumentException{
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

        return new JwtTokenResponse(jwt);
    }

    @Override
    public Utente signup(AuthRequest utente) {
        Utente u = new Utente(utente.getEmail(), encoder.encode(utente.getPassword()));
        //u = utenteRepository.save(u);
        if (utente.getTipoUtente().equalsIgnoreCase("Privato")) {
            UtentePrivato privato = new UtentePrivato(u.getEmail(),u.getPassword());
            privato.setCf(utente.getCf());
            privato.setNome(utente.getNome());
            privato.setCognome(utente.getCognome());
            privato.setTelefono(utente.getTelefono());
            privato.setPreferenze(utente.getPreferenze());
            privato.setCondizioni_abitative(utente.getCondizioni_abitative());
            privato.setInformazioni_aggiuntive(utente.getCondizioni_abitative());
            privato.setId(u.getId());
            utentePrivatoRepository.save(privato);
            return privato;
        }
        CentroAdozioni centro = new CentroAdozioni(u.getEmail(),u.getPassword());
        centro.setNome(utente.getNome());
        centro.setDescrizione(utente.getDescrizione());
        centro.setEventi(utente.getEventi());
        centro.setIndirizzo(utente.getIndirizzo());
        centro.setOrari(utente.getOrari());
        centroAdozioniRepository.save(centro);
        return centro;
    }
}
