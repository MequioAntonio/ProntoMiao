package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model_old.CentroAdozioni;
import it.unical.prontoMiao.repository.CentroAdozioniRepository;
import it.unical.prontoMiao.service.CentroAdozioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CentroAdozioniServiceImpl implements CentroAdozioniService {
    @Autowired
    private CentroAdozioniRepository centroAdozioniRepository;
    @Override
    public List<CentroAdozioni> getCentriAdozione() {
        return centroAdozioniRepository.findAll();

    }
    public Optional<CentroAdozioni> getCentroByID(int id)  {

        return Optional.of(centroAdozioniRepository.findCentroById(id));

    }

    @Override
    public void deleteCentroAdozioni(int idCentroAdozioni) {
        centroAdozioniRepository.deleteById(idCentroAdozioni);

    }

}
