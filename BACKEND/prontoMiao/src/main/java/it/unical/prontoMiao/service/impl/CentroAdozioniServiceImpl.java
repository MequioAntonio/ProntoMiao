package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.CentroAdozioni;
import it.unical.prontoMiao.repository.CentroAdozioniRepository;
import it.unical.prontoMiao.service.CentroAdozioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CentroAdozioniServiceImpl implements CentroAdozioniService {
    @Autowired
    private CentroAdozioniRepository centroAdozioniRepository;
    @Override
    public List<CentroAdozioni> getCentriAdozione() {
        return centroAdozioniRepository.findAll();

    }


    @Override
    public CentroAdozioni getCentroByEmail(String email) {
        return centroAdozioniRepository.findByEmail("%"+email+"%");
    }
}
