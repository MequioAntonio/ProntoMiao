package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.model.Recensione;
import it.unical.prontoMiao.model.Richiesta;
import it.unical.prontoMiao.model.UtentePrivato;
import it.unical.prontoMiao.repository.AnimaleRepository;
import it.unical.prontoMiao.repository.AnnuncioRepository;
import it.unical.prontoMiao.repository.CentroAdozioniRepository;
import it.unical.prontoMiao.repository.RichiestaRepository;
import it.unical.prontoMiao.service.RichiestaService;
import it.unical.prontoMiao.utility.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
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

    @Override
    public List<Richiesta> getRichiesteByCentro(int idCentro) throws ChangeSetPersister.NotFoundException{
        List<Richiesta> list = richiestaRepository.findByAnnuncio_Centro_Id(idCentro);
        if (list.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return list;
    }

    @Override
    public List<Richiesta> getRichiesteByUtente(int idUtente) throws ChangeSetPersister.NotFoundException{
        List<Richiesta> list = richiestaRepository.findByUtente_Id(idUtente);
        if (list.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return list;
    }

    @Override
    public Richiesta updateRichiesta(int id, Richiesta up) {
        up.setId(id);
        return richiestaRepository.save(up);
    }

}
