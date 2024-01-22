package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.Animale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimaleRepository extends JpaRepository<Animale,Integer> {
}
