package it.unical.prontoMiao.persistenza.dao;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import it.unical.prontoMiao.persistenza.model.Animale;

public interface AnimaleDao {
    public List<Animale> getAnimali();
    public List<Animale> getAnimaleByNome(String nome);
    public void insertAnimale(Animale a);
    public void updateAnimale(Animale a);
    public void deleteAnimale(int idAnimale);
    public Animale getAnimaleById(int idAnimale);
    public List<Animale> getAnimaliSenzaAnnuncio();

    // List<Animale> findByNomeLike(String nome);

    // List<Animale> findByNomeLikeIgnoreCaseAndRazzaLikeIgnoreCaseAndTagliaLikeIgnoreCaseOrderByNomeAsc(@Nullable String nome, @Nullable String razza, @Nullable String taglia);
}
