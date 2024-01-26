package it.unical.prontoMiao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "annuncio")
public class Annuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String descrizione;
    @Column(nullable = false)
    private String informazioni_mediche;
    @Column(nullable = false)
    private String titolo;
    @Column(nullable = false)
    private String foto_profilo;
    @ManyToOne
    @JoinColumn(name = "id_centro", nullable = false)
    private CentroAdozioni centro;
    @OneToOne
    @JoinColumn(name = "id_animale", nullable = false)
    private Animale animale;

    public Annuncio() {
    }

    public Annuncio(int id, String descrizione, String informazioni_mediche, String titolo, String foto_profilo) {
        this.id = id;
        this.descrizione = descrizione;
        this.informazioni_mediche = informazioni_mediche;
        this.titolo = titolo;
        this.foto_profilo = foto_profilo;
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

    public String getFoto_profilo() {
        return foto_profilo;
    }

    public void setFoto_profilo(String foto_profilo) {
        this.foto_profilo = foto_profilo;
    }
}


