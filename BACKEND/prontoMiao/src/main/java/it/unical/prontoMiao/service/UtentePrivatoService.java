package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model.UtentePrivato;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface UtentePrivatoService {
    public List<UtentePrivato> getUtentiPrivati();

    public Optional<UtentePrivato> getUtenteByEmail(String email) throws ChangeSetPersister.NotFoundException;

    public Optional<UtentePrivato> getUtenteByID(int id) throws ChangeSetPersister.NotFoundException;

    public UtentePrivato insertUtentePrivato(UtentePrivato up);
    public UtentePrivato updateUtentePrivato(int id, UtentePrivato up);
    public void deleteUtentePrivato(int id);
    public UtentePrivato loadUserByUsername(String email);

}
