package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.persistenza.dao.CentroAdozioniDao;
import it.unical.prontoMiao.persistenza.dao.postgres.CentroAdozioniDaoPostgres;
import it.unical.prontoMiao.persistenza.model.CentroAdozioni;
import it.unical.prontoMiao.persistenza.dao.UtentePrivatoDao;
import it.unical.prontoMiao.persistenza.dao.postgres.UtentePrivatoDaoPostgres;
import it.unical.prontoMiao.persistenza.model.Utente;
import it.unical.prontoMiao.persistenza.model.UtentePrivato;
import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.dao.UtenteDao;
import it.unical.prontoMiao.persistenza.dao.postgres.UtenteDaoPostgres;
import it.unical.prontoMiao.repository.CentroAdozioniRepository;
import it.unical.prontoMiao.repository.UtentePrivatoRepository;
import it.unical.prontoMiao.repository.UtenteRepository;
import it.unical.prontoMiao.request.AuthRequest;
import it.unical.prontoMiao.response.JwtTokenResponse;
import it.unical.prontoMiao.service.AuthenticationService;
import it.unical.prontoMiao.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    //@Autowired
    //UtenteRepository utenteRepository;
    private UtenteDao utenteRepository = new UtenteDaoPostgres(DBManager.getInstance().getConnection());

    private UtentePrivatoDao utentePrivatoRepository = new UtentePrivatoDaoPostgres(DBManager.getInstance().getConnection());

    private CentroAdozioniDao centroAdozioniRepository = new CentroAdozioniDaoPostgres(DBManager.getInstance().getConnection());
    //@Autowired
    //UtentePrivatoRepository utentePrivatoRepository;
    //@Autowired
    //CentroAdozioniRepository centroAdozioniRepository;
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

        Utente user = null;
        Optional<UtentePrivato> optPrivato = utentePrivatoRepository.findByEmailIgnoreCase(utente.getEmail());
        Optional<CentroAdozioni> optCentro = centroAdozioniRepository.findByEmailIgnoreCase(utente.getEmail());
        String tipoUtente = "NA";
        if (optPrivato.isPresent()) {
            user = optPrivato.get();
            tipoUtente = "PRIVATO";
        }
        if (optCentro.isPresent()) {
            user = optCentro.get();
            tipoUtente = "CENTRO";
        }
        if (user == null) {
            user = utenteRepository.findByEmailIgnoreCase(utente.getEmail())
                    .orElseThrow(() -> new IllegalArgumentException("Credenziali errate"));
        }
        if(!encoder.matches(utente.getPassword(),user.getPassword())){
            throw new IllegalArgumentException("Credenziali errate");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("tipo", tipoUtente);
        claims.put("id", user.getId());
        String jwt = jwtService.generateToken(claims, user);

        return new JwtTokenResponse(jwt);
    }

    @Override
    public Utente signup(AuthRequest utente) throws SQLException {
        Utente u = new Utente(utente.getEmail(), encoder.encode(utente.getPassword()));
        if (utente.getTipoUtente().equalsIgnoreCase("Privato")) {
            UtentePrivato privato = new UtentePrivato(u.getEmail(),u.getPassword());
            privato.setCodice_fiscale(utente.getCf());
            privato.setNome(utente.getNome());
            privato.setCognome(utente.getCognome());
            privato.setTelefono(utente.getTelefono());
            privato.setPreferenze(utente.getPreferenze());
            privato.setIndirizzo(utente.getIndirizzo());
            privato.setInformazioni_aggiuntive(utente.getInformazioni());
            privato.setCondizioni_abitative(utente.getCondizioni());
            //privato.setId(u.getId());
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
