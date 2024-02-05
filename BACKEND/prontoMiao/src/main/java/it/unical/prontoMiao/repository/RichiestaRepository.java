package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model_old.Richiesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RichiestaRepository extends JpaRepository<Richiesta,Integer> {
    Optional<Richiesta> findById(int idRichiesta);
    List<Richiesta> findByAnnuncio_Centro_Id(int idCentro);
    List<Richiesta> findByUtente_Id(int idUtente);
}
