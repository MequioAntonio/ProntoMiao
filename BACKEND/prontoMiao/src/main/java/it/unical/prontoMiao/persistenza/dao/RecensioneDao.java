package it.unical.prontoMiao.persistenza.dao;

import java.io.IOException;
import java.util.List;


import it.unical.prontoMiao.persistenza.model.Recensione;

public interface RecensioneDao {
    public List<Recensione> getRecensione();
    public Recensione getRecensioneById(Integer idRecensione);
    public List<Recensione> getRecensioniByCentro(Integer idCentro);
    public Recensione insertRecensione(Recensione recensione);
    public void deleteRecensioneById(Integer idRecensione);
}
