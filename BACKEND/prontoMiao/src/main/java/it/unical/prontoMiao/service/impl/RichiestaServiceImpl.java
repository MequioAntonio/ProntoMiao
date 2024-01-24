package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.model.Richiesta;
import it.unical.prontoMiao.repository.AnimaleRepository;
import it.unical.prontoMiao.repository.AnnuncioRepository;
import it.unical.prontoMiao.repository.CentroAdozioniRepository;
import it.unical.prontoMiao.repository.RichiestaRepository;
import it.unical.prontoMiao.service.RichiestaService;
import it.unical.prontoMiao.utility.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class RichiestaServiceImpl implements RichiestaService {
    @Autowired
    private RichiestaRepository richiestaRepository;

    @Override
    public List<Richiesta> getRichiesta() {
        return richiestaRepository.findAll();
    }

    @Override
    public Richiesta getRichiestaById(int idRichiesta) throws ChangeSetPersister.NotFoundException {
        Optional<Richiesta> opt = richiestaRepository.findById(idRichiesta);
        if (opt.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return opt.get();
    }

    @Override
    public Richiesta insertRichiesta(Richiesta richiesta) throws IOException {
        richiesta = richiestaRepository.save(richiesta);
        return richiesta;
    }
}
