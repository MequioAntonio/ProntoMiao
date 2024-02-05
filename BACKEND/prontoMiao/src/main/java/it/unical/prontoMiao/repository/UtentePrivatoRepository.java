package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model_old.UtentePrivato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtentePrivatoRepository extends JpaRepository<UtentePrivato, Integer> {


    UtentePrivato findByNomeLike(String nome);

    UtentePrivato findByEmail(String email);

    UtentePrivato findById(int id);

    Optional<UtentePrivato> findByEmailIgnoreCase(String email);

}
