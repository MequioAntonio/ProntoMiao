package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model_old.Animale;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface AnimaleService {
    public List<Animale> getAnimali(String nome, String razza, String taglia);
    public List<Animale> getAnimaleByNome(String nome);
    public Animale insertAnimale(Animale a);
    public Animale updateAnimale(int idAnimale, Animale a);
    public void deleteAnimale(int idAnimale);
    public Animale getAnimaleById(int idAnimale) throws ChangeSetPersister.NotFoundException;
    public List<Animale> getAnimaliSenzaAnnuncio();
}
