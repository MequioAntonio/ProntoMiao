package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.Animale;
import it.unical.prontoMiao.model.Annuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface AnnuncioRepository extends JpaRepository<Annuncio,Integer> {

    Optional<Annuncio> findById(int idAnnuncio);
    List<Annuncio> findByCentro_Id(int idCentro);

    @Query(
            value = "select * from annuncio where annuncio.id IN (SELECT annuncio.id  FROM annuncio  EXCEPT  SELECT richiesta.id_annuncio  FROM richiesta  WHERE richiesta.stato = 2)",
            nativeQuery = true)
    List<Annuncio> findAllNotInRichiestaAccettata();

}
