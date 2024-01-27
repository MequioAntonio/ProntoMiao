package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.Animale;
import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.repository.AnimaleRepository;
import it.unical.prontoMiao.repository.AnnuncioRepository;
import it.unical.prontoMiao.repository.CentroAdozioniRepository;
import it.unical.prontoMiao.service.AnnuncioService;
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
public class AnnuncioServiceImpl implements AnnuncioService {
    @Autowired
    private AnnuncioRepository annuncioRepository;

    @Autowired
    private AnimaleRepository animaleRepository;

    @Autowired
    private CentroAdozioniRepository centroAdozioniRepository;
    @Autowired
    private FileUtility fileUtility;
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
    public Annuncio insertAnnuncio(Annuncio annuncio) throws IOException {
        //System.out.println(annuncio.getFoto_profilo());
        String fileEncoded = annuncio.getFoto_profilo();
        annuncio.setFoto_profilo(fileUtility.getNomeFIle(fileEncoded));
        annuncio = annuncioRepository.save(annuncio);
        fileUtility.base64ToFile(fileEncoded,"annuncio/"+Integer.toString(annuncio.getId()));
        annuncio.setFoto_profilo(fileUtility.generaUrlImmagine("annuncio",annuncio.getId(),annuncio.getFoto_profilo()));

        return annuncioRepository.save(annuncio);
    }

    @Override
    public List<Annuncio> getAnnunciByCentro(int idAnnuncio)  throws ChangeSetPersister.NotFoundException{
        Optional<Annuncio> opt = annuncioRepository.findByCentro_Id(idAnnuncio);
        if (opt.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return (List<Annuncio>) opt.get();
    }
}
