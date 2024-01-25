package it.unical.prontoMiao.service;

import it.unical.prontoMiao.model.CentroAdozioni;

import java.util.List;

public interface CentroAdozioniService {
    public List<CentroAdozioni> getCentriAdozione();

    public CentroAdozioni getCentroByEmail(String email);

    public void deleteCentroAdozioni(int idCentroAdozioni);

}
