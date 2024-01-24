package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.Utente;
import it.unical.prontoMiao.model.UtentePrivato;
import it.unical.prontoMiao.repository.UtentePrivatoRepository;
import it.unical.prontoMiao.service.UtentePrivatoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UtentePrivatoServiceImpl implements UtentePrivatoService {
    @Autowired
    private UtentePrivatoRepository utentePrivatoRepository;
    @Override
    public List<UtentePrivato> getUtentiPrivati() {
        return utentePrivatoRepository.findAll();
    }

    @Override
    public UtentePrivato loadUserByUsername(String email) {
        UtentePrivato utentePrivato = utentePrivatoRepository.findByEmail(email);
        if (utentePrivato == null) {
            throw new RuntimeException("User not found");
        }
        return new UtentePrivato(utentePrivato.getEmail(), utentePrivato.getPassword(), utentePrivato.getNome(), utentePrivato.getCf());
    }

    public Optional<UtentePrivato> getUtenteByEmail(String email)  {

        return Optional.ofNullable(utentePrivatoRepository.findByEmail(email));

    }
    public Optional<Optional<UtentePrivato>> getUtenteByID(String id)  {

        return Optional.of(utentePrivatoRepository.findById(id));

    }


    @Override
    public UtentePrivato insertUtentePrivato(UtentePrivato up) {
        return utentePrivatoRepository.save(up);
    }

    @Override
    public UtentePrivato updateUtentePrivato(String email, UtentePrivato up) {
        up.setEmail(email);
        return utentePrivatoRepository.save(up);
    }

    @Override
    public void deleteUtentePrivato(String email) {
        utentePrivatoRepository.deleteById(email);
    }





}
