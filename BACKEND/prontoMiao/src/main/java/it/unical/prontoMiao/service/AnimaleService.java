package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model.Animale;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AnimaleService {
    public List<Animale> getAnimali(String nome, String razza, String taglia);
    public List<Animale> getAnimaleByNome(String nome);
    public Animale insertAnimale(Animale a);
}
