package it.unical.prontoMiao.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "annuncio")
public class Annuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NonNull
    private String descrizione;
    @NonNull
    private String informazioni_mediche;
    @NonNull
    private String titolo;
    @ManyToOne
    @JoinColumn(name = "id_centro")
    private CentroAdozioni centro;

    @OneToOne
    @JoinColumn(name = "id_animale")
    private Animale animale;

    public Annuncio() {
    }

    public Annuncio(int id, String descrizione, String informazioni_mediche, String titolo) {
        this.id = id;
        this.descrizione = descrizione;
        this.informazioni_mediche = informazioni_mediche;
        this.titolo = titolo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public String getInformazioni_mediche() {
        return informazioni_mediche;
    }

    public void setInformazioni_mediche(String informazioni_mediche) {
        this.informazioni_mediche = informazioni_mediche;
    }

    public String getTitolo() {
        return titolo;
    }


    public void setTitolo(String titolo) {this.titolo = titolo;}



}
