package it.unical.prontoMiao.persistenza.model;

public class Segnalazione {
    private int id;
    private String titolo;
    private String descrizione;
    private String indirizzo;
    private CentroAdozioni centro;
    private UtentePrivato utente;

    public Segnalazione() {
    }

    public Segnalazione(int id, String titolo, String descrizione, String indirizzo, CentroAdozioni centro, UtentePrivato utente) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.indirizzo = indirizzo;
        this.centro = centro;
        this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public CentroAdozioni getCentro() {
        return centro;
    }

    public void setCentro(CentroAdozioni centro) {
        this.centro = centro;
    }

    public UtentePrivato getUtente() {
        return utente;
    }

    public void setUtente(UtentePrivato utente) {
        this.utente = utente;
    }
}
