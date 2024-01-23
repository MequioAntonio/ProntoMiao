package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.model.Animale;
import it.unical.prontoMiao.repository.AnimaleRepository;
import it.unical.prontoMiao.service.AnimaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    @Override
    public Animale insertAnimale(Animale a){
        return animaleRepository.save(a);
    }
    @Override
    public Animale updateAnimale(int idAnimale, Animale a){
        a.setId(idAnimale);
        return animaleRepository.save(a);
    }
    @Override
    public void deleteAnimale(int idAnimale){
        animaleRepository.deleteById(idAnimale);
    }
    @Override
    public Animale getAnimaleById(int idAnimale) throws ChangeSetPersister.NotFoundException {
        Optional<Animale> opt = animaleRepository.findById(idAnimale);
        if (opt.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return opt.get();
    }
}
