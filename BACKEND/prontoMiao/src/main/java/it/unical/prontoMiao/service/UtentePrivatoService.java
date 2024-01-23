package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model.Animale;
import it.unical.prontoMiao.model.UtentePrivato;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface UtentePrivatoService {
    public List<UtentePrivato> getUtentiPrivati();

    public UtentePrivato getUtenteByEmail(String email) throws ChangeSetPersister.NotFoundException;

    public UtentePrivato insertUtentePrivato(UtentePrivato up);
    public UtentePrivato updateUtentePrivato(String email, UtentePrivato up);
    public void deleteUtentePrivato(String email);

}
