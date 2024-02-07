package it.unical.prontoMiao.persistenza.model;

import java.sql.Date; //se crea problemi cabiare da java.sql a java.util

public class Richiesta {
    private Integer id;
    private Integer stato;
    private Date data;
    private UtentePrivato utente;
    private Annuncio annuncio;

    public Richiesta() {
    }

    public Richiesta(Integer id, Integer stato, Date data, UtentePrivato utente, Annuncio annuncio) {
        this.id = id;
        this.stato = stato;
        this.data = data;
        this.utente = utente;
        this.annuncio = annuncio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStato() {
        return stato;
    }

    public void setStato(Integer stato) {
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
