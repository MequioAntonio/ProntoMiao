package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.model.Richiesta;
import it.unical.prontoMiao.model.Segnalazione;
import it.unical.prontoMiao.repository.AnimaleRepository;
import it.unical.prontoMiao.repository.AnnuncioRepository;
import it.unical.prontoMiao.repository.CentroAdozioniRepository;
import it.unical.prontoMiao.repository.SegnalazioneRepository;
import it.unical.prontoMiao.service.AnnuncioService;
import it.unical.prontoMiao.service.SegnalazioneService;
import it.unical.prontoMiao.utility.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class SegnalazioneServiceImpl implements SegnalazioneService {
    @Autowired
    private SegnalazioneRepository segnalazioneRepository;
    @Autowired
    private CentroAdozioniRepository centroAdozioniRepository;
    @Override
    public List<Segnalazione> getSegnalazione() {
        return segnalazioneRepository.findAll();
    }

    @Override
    public Segnalazione getSegnalazioneById(int idSegnalazione) throws ChangeSetPersister.NotFoundException{
        Optional<Segnalazione> opt = segnalazioneRepository.findById(idSegnalazione);
        if (opt.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return opt.get();
    }
    @Override
    public Segnalazione insertSegnalazione(Segnalazione segnalazione) throws IOException {
        //System.out.println(annuncio.getFoto_profilo());
        segnalazione = segnalazioneRepository.save(segnalazione);
        return segnalazioneRepository.save(segnalazione);
    }
    @Override
    public Segnalazione updateSegnalazione(int id, Segnalazione up) {
        up.setId(id);
        return segnalazioneRepository.save(up);
    }
}
