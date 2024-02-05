package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.Richiesta;

import java.util.List;


public interface RichiestaDao {
    public List<Richiesta> getRichiesta();
    public Richiesta getRichiestaById(Integer idRichiesta);
    public List<Richiesta> getRichiestaByCentro(Integer idCentro);
    public Richiesta insertRichieta (Richiesta richiesta);
    public void deleteRichiestaById(Integer idRichiesta);


}
