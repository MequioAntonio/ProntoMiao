package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.UtentePrivato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtentePrivatoRepository extends JpaRepository<UtentePrivato, String> {
}
