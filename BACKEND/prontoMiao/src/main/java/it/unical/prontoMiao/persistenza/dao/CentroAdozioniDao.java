package it.unical.prontoMiao.persistenza.dao;



import it.unical.prontoMiao.persistenza.model.CentroAdozioni;

import java.util.Optional;

public interface CentroAdozioniDao {

    public CentroAdozioni findCentroById(int id);

    public Optional<CentroAdozioni> findByEmailIgnoreCase(String email);

}
