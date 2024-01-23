package it.unical.prontoMiao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "annuncio")
public class Annuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titolo;
    private String foto_profilo;
    private String descrizione;
    private String indirizzo;
    private String informazioni_mediche;
    @ManyToOne
    @JoinColumn(name = "id_centro")
    private CentroAdozioni centro;

    @OneToOne
    @JoinColumn(name = "id_animale")
    private Animale animale;

    public Annuncio() {
    }

    public Annuncio(int id, String titolo, String foto_profilo, String descrizione, String indirizzo, String informazioni_mediche, CentroAdozioni centro, Animale animale) {
        this.id = id;
        this.titolo = titolo;
        this.foto_profilo = foto_profilo;
        this.descrizione = descrizione;
        this.indirizzo = indirizzo;
        this.informazioni_mediche = informazioni_mediche;
        this.centro = centro;
        this.animale = animale;
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

    public String getFoto_profilo() {
        return foto_profilo;
    }

    public void setFoto_profilo(String foto_profilo) {
        this.foto_profilo = foto_profilo;
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

    public String getInformazioni_mediche() {
        return informazioni_mediche;
    }

    public void setInformazioni_mediche(String informazioni_mediche) {
        this.informazioni_mediche = informazioni_mediche;
    }

    public Animale getAnimale() {
        return animale;
    }

    public void setAnimale(Animale animale) {
        this.animale = animale;
    }

    public CentroAdozioni getCentro() {
        return centro;
    }

    public void setCentro(CentroAdozioni centro) {
        this.centro = centro;
    }

}
