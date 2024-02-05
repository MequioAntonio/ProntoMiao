package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.model_old.CentroAdozioni;

import java.util.Optional;

public interface CentroAdozioniDao {

    CentroAdozioni findCentroById(int id);

    Optional<CentroAdozioni> findByEmailIgnoreCase(String email);

}
