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
            value = "SELECT * FROM annuncio WHERE annuncio.id IN (SELECT x.id_annuncio from (SELECT richiesta.id_annuncio, max(stato) status FROM richiesta GROUP BY richiesta.id_annuncio) x where status <> 2) ORDER BY annuncio.id ASC",
            nativeQuery = true)
    List<Annuncio> findAllNotInRichiestaAccettata();

}
