package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model_old.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecensioneRepository extends JpaRepository<Recensione,Integer> {
    Optional<Recensione> findById(int idRecensione);

    Optional<Recensione> deleteById(int idRecensione);

    List<Recensione> findByCentro_Id(int idCentro);

}
