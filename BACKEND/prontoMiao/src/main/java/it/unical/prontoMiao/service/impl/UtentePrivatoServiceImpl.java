package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.persistenza.model.UtentePrivato;
import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.dao.UtentePrivatoDao;
import it.unical.prontoMiao.persistenza.dao.postgres.UtentePrivatoDaoPostgres;
import it.unical.prontoMiao.repository.UtentePrivatoRepository;
import it.unical.prontoMiao.service.UtentePrivatoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UtentePrivatoServiceImpl implements UtentePrivatoService {
    //@Autowired
    //private UtentePrivatoRepository utentePrivatoRepository;

    private UtentePrivatoDao utentePrivatoRepository = new UtentePrivatoDaoPostgres(DBManager.getInstance().getConnection());
    @Override
    public List<UtentePrivato> getUtentiPrivati() throws SQLException {
        return utentePrivatoRepository.findAll();
    }

    @Override
    public UtentePrivato loadUserByUsername(String email) throws SQLException {
        UtentePrivato utentePrivato = utentePrivatoRepository.findByEmail(email);
        if (utentePrivato == null) {
            throw new RuntimeException("User not found");
        }
        return new UtentePrivato(utentePrivato.getEmail(), utentePrivato.getPassword(), utentePrivato.getNome(), utentePrivato.getCognome(), utentePrivato.getCodice_fiscale(), utentePrivato.getIndirizzo());
    }

    public Optional<UtentePrivato> getUtenteByEmail(String email) throws SQLException {

        return Optional.ofNullable(utentePrivatoRepository.findByEmail(email));

    }
    public Optional<UtentePrivato> getUtenteByID(int id) throws SQLException {

        return Optional.of(utentePrivatoRepository.findById(id));

    }


    @Override
    public UtentePrivato insertUtentePrivato(UtentePrivato up) throws SQLException {
        return utentePrivatoRepository.save(up);
    }

    @Override
    public UtentePrivato updateUtentePrivato(int id, UtentePrivato up) throws SQLException {
        up.setId(id);
        return utentePrivatoRepository.save(up);
    }

    @Override
    public void deleteUtentePrivato(int id) throws SQLException {
        utentePrivatoRepository.deleteById(id);
    }





}
