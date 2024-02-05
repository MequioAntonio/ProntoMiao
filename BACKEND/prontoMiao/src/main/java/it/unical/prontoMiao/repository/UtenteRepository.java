package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model_old.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {
    Optional<Utente> findByEmailIgnoreCase(String email);

}
