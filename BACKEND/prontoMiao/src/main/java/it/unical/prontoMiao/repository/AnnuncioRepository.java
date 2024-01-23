package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.Annuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface AnnuncioRepository extends JpaRepository<Annuncio,Integer> {

    Optional<Annuncio> findById(int idAnnuncio);
}
