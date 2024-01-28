package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.Animale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimaleRepository extends JpaRepository<Animale,Integer> {
    List<Animale> findByNomeLike(String nome);

    List<Animale> findByNomeLikeIgnoreCaseAndRazzaLikeIgnoreCaseAndTagliaLikeIgnoreCaseOrderByNomeAsc(@Nullable String nome, @Nullable String razza, @Nullable String taglia);

    @Query(
            value = "SELECT * FROM animale WHERE animale.id NOT IN (SELECT id_animale FROM annuncio)",
            nativeQuery = true)
    List<Animale> findAllNotInAnnuncio();



}
