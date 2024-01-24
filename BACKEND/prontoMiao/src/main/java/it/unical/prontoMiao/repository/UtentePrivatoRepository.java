package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.Animale;
import it.unical.prontoMiao.model.UtentePrivato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtentePrivatoRepository extends JpaRepository<UtentePrivato, String> {


    UtentePrivato findByNomeLike(String nome);

    UtentePrivato findByEmail(String email);
}
