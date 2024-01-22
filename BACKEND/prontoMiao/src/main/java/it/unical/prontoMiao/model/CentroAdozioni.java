package it.unical.prontoMiao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="centro_adozioni")
public class CentroAdozioni extends Utente{


    private String descrizione;
    private String orari;
    private String eventi;

    public CentroAdozioni() {
    }

    public CentroAdozioni(String email, String password, String descrizione, String orari, String eventi) {
        super(email, password);
        this.descrizione = descrizione;
        this.orari = orari;
        this.eventi = eventi;
    }

    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getOrari() {
        return orari;
    }

    public void setOrari(String orari) {
        this.orari = orari;
    }

    public String getEventi() {
        return eventi;
    }

    public void setEventi(String eventi) {
        this.eventi = eventi;
    }
}
