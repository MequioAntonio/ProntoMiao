package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.CentroAdozioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroAdozioniRepository extends JpaRepository<CentroAdozioni, String> {

}
