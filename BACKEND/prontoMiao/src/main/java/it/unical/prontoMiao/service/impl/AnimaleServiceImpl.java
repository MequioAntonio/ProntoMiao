package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.Animale;
import it.unical.prontoMiao.repository.AnimaleRepository;
import it.unical.prontoMiao.service.AnimaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //per la concorrenza
public class AnimaleServiceImpl implements AnimaleService {
    @Autowired
    private AnimaleRepository animaleRepository;
    @Override
    public List<Animale> getAnimali(String nome, String razza, String taglia) {
        return animaleRepository.findByNomeLikeIgnoreCaseAndRazzaLikeIgnoreCaseAndTagliaLikeIgnoreCaseOrderByNomeAsc("%"+nome+"%", "%"+razza+"%", "%"+taglia+"%");
    }

    @Override
    public List<Animale> getAnimaleByNome(String nome) {
        return animaleRepository.findByNomeLike("%"+nome+"%");
    }
}
