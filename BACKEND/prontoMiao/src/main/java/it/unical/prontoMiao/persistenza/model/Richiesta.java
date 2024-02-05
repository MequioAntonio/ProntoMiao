package it.unical.prontoMiao.persistenza.model;

import java.sql.Date; //se crea problemi cabiare da java.sql a java.util

public class Richiesta {
    private int id;
    private int stato;
    private Date data;
    private UtentePrivato utente;
    private Annuncio annuncio;

    public Richiesta() {
    }

    public Richiesta(int id, int stato, Date data, UtentePrivato utente, Annuncio annuncio) {
        this.id = id;
        this.stato = stato;
        this.data = data;
        this.utente = utente;
        this.annuncio = annuncio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public UtentePrivato getUtente() {
        return utente;
    }

    public void setUtente(UtentePrivato utente) {
        this.utente = utente;
    }

    public Annuncio getAnnuncio() {
        return annuncio;
    }

    public void setAnnuncio(Annuncio annuncio) {
        this.annuncio = annuncio;
    }
}
