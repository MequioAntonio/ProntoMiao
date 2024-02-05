package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.model_old.CentroAdozioni;
import it.unical.prontoMiao.persistenza.dao.CentroAdozioniDao;

import java.util.Optional;

public class CentroAdozioniDaoPostgres implements CentroAdozioniDao {
    @Override
    public CentroAdozioni findCentroById(int id) {
        return null;
    }

    @Override
    public Optional<CentroAdozioni> findByEmailIgnoreCase(String email) {
        return Optional.empty();
    }
}
