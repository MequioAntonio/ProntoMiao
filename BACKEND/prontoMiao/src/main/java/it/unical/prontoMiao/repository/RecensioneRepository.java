package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.Recensione;
import org.apache.coyote.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecensioneRepository extends JpaRepository<Recensione,Integer> {
    Optional<Recensione> findById(int idRecensione);

    Optional<Recensione> deleteById(int idRecensione);

    Optional<Recensione> findByCentro_Id(int idCentro);

}
