package it.unical.prontoMiao.model;

import jakarta.persistence.*;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "richiesta")
public class Richiesta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int stato;
    @Column(nullable = false)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private UtentePrivato utente;

    @ManyToOne
    @JoinColumn(name = "id_annuncio", nullable = false)
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
