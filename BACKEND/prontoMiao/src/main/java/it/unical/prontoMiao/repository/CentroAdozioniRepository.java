package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.CentroAdozioni;
import it.unical.prontoMiao.model.UtentePrivato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentroAdozioniRepository extends JpaRepository<CentroAdozioni, Integer> {

    //CentroAdozioni findByNomeLike(String nome);
    CentroAdozioni findCentroById(int id);

    Optional<CentroAdozioni> findByEmailIgnoreCase(String email);


}
