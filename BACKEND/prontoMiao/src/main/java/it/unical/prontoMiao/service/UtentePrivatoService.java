package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model.UtentePrivato;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface UtentePrivatoService {
    public List<UtentePrivato> getUtentiPrivati();

    public Optional<UtentePrivato> getUtenteByEmail(String email) throws ChangeSetPersister.NotFoundException;

    public Optional<Optional<UtentePrivato>> getUtenteByID(String id) throws ChangeSetPersister.NotFoundException;

    public UtentePrivato insertUtentePrivato(UtentePrivato up);
    public UtentePrivato updateUtentePrivato(String email, UtentePrivato up);
    public void deleteUtentePrivato(String email);
    public UtentePrivato loadUserByUsername(String email);

}
