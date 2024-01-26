package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.CentroAdozioni;
import it.unical.prontoMiao.model.UtentePrivato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroAdozioniRepository extends JpaRepository<CentroAdozioni, Integer> {

    //CentroAdozioni findByNomeLike(String nome);
    CentroAdozioni findCentroById(int id);

}
