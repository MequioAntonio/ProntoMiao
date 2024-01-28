package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model.CentroAdozioni;

import java.util.List;
import java.util.Optional;

public interface CentroAdozioniService {
    public List<CentroAdozioni> getCentriAdozione();

    public Optional<CentroAdozioni> getCentroByID(int idCentroAdozioni);

    public void deleteCentroAdozioni(int idCentroAdozioni);

}
