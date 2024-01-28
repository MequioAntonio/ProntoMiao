package it.unical.prontoMiao.repository;

import it.unical.prontoMiao.model.Annuncio;
import it.unical.prontoMiao.model.Segnalazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SegnalazioneRepository extends JpaRepository<Segnalazione,Integer>{

        Optional<Segnalazione> findById(int idSegnalazione);

    }
