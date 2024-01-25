package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.Recensione;
import it.unical.prontoMiao.repository.RecensioneRepository;
import it.unical.prontoMiao.service.RecensioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class RecensioneServiceImp implements RecensioneService {
    @Autowired
    RecensioneRepository recensioneRepository;
    @Override
    public List<Recensione> getRecensione() {
        return recensioneRepository.findAll();
    }

    @Override
    public Recensione getRecensioneById(int idRecensione) throws ChangeSetPersister.NotFoundException {
        Optional<Recensione> opt = recensioneRepository.findById(idRecensione);
        if(opt.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return opt.get();
    }

    @Override
    public Recensione insertRecensione(Recensione recensione) throws IOException {
        return null;
    }

    @Override
    public void deleteRecensioneById(int idRecensione) {

    }
}
