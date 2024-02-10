package it.unical.prontoMiao.persistenza.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CentroAdozioni extends Utente{

    private String nome;
    private String descrizione;
    private String orari;
    private String eventi;
    private String indirizzo;

    private List<Annuncio> annunci = new ArrayList<Annuncio>();

    public CentroAdozioni() {
    }

    public CentroAdozioni(String nome, String descrizione, String orari, String eventi, String indirizzo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.orari = orari;
        this.eventi = eventi;
        this.indirizzo = indirizzo;
    }

    public CentroAdozioni(String email, String password) {
        super(email, password);
    }

    public void setAnnunci(List<Annuncio> annunci) {
        this.annunci = annunci;
    }

    public List<Annuncio> getAnnunci() throws SQLException {
        return annunci;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
