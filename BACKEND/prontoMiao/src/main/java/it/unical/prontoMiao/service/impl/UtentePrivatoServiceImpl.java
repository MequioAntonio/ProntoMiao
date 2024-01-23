package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.UtentePrivato;
import it.unical.prontoMiao.repository.UtentePrivatoRepository;
import it.unical.prontoMiao.service.UtentePrivatoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public UtentePrivato getUtenteByEmail(String email) throws ChangeSetPersister.NotFoundException {
        return utentePrivatoRepository.findByEmail("%"+email+"%");
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
