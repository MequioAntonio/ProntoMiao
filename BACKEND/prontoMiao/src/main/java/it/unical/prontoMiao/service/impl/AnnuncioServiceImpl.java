package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.repository.AnnuncioRepository;
import it.unical.prontoMiao.service.AnnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AnnuncioServiceImpl implements AnnuncioService {
    @Autowired
    private AnnuncioRepository annuncioRepository;
    @Override
    public List<Annuncio> getAnnunci() {
        return annuncioRepository.findAll();
    }
}
