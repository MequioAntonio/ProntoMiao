package it.unical.prontoMiao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "segnalazione")
public class Segnalazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String titolo;
    @Column(nullable = false)
    private String descrizione;
    @Column(nullable = false)
    private String indirizzo;
    @ManyToOne
    @JoinColumn(name = "id_centro")
    private CentroAdozioni centro;
    @ManyToOne
    @JoinColumn(name = "id_privato", nullable = false)
    private UtentePrivato utente;

    public Segnalazione() {
    }

    public Segnalazione(int id, String titolo, String descrizione, String indirizzo) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.indirizzo = indirizzo;
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
