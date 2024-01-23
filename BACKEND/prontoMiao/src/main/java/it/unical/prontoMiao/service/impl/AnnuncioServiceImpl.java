package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.Animale;
import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.repository.AnnuncioRepository;
import it.unical.prontoMiao.service.AnnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnnuncioServiceImpl implements AnnuncioService {
    @Autowired
    private AnnuncioRepository annuncioRepository;
    @Override
    public List<Annuncio> getAnnunci() {
        return annuncioRepository.findAll();
    }

    @Override
    public Annuncio getAnnuncioById(int idAnnuncio) throws ChangeSetPersister.NotFoundException{
        Optional<Annuncio> opt = annuncioRepository.findById(idAnnuncio);
        if (opt.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return opt.get();
    }

    @Override
    public List<Annuncio> getAnnunciByCentro(Integer id)  throws ChangeSetPersister.NotFoundException{
        Optional<Annuncio> opt = annuncioRepository.findByCentro(id);
        if (opt.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return (List<Annuncio>) opt.get();
    }
}
