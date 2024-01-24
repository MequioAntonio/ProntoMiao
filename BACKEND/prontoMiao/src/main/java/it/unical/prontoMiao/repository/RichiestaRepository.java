package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.model.Richiesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RichiestaRepository extends JpaRepository<Richiesta,Integer> {
    Optional<Richiesta> findById(int idRichiesta);
}
