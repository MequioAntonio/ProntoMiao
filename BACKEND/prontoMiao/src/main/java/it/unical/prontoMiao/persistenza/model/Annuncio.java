package it.unical.prontoMiao.persistenza.model;

public class Annuncio {

    private int id;
    private String descrizione;
    private String informazioni_mediche;
    private String titolo;
    private String foto_profilo;
    private CentroAdozioni centro;
    private Animale animale;

    public Annuncio() {
    }

    public Annuncio(int id, String descrizione, String informazioni_mediche, String titolo, String foto_profilo, CentroAdozioni centro, Animale animale) {
        this.id = id;
        this.descrizione = descrizione;
        this.informazioni_mediche = informazioni_mediche;
        this.titolo = titolo;
        this.foto_profilo = foto_profilo;
        this.centro = centro;
        this.animale = animale;
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

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getFoto_profilo() {
        return foto_profilo;
    }

    public void setFoto_profilo(String foto_profilo) {
        this.foto_profilo = foto_profilo;
    }

    public CentroAdozioni getCentro() {
        return centro;
    }

    public void setCentro(CentroAdozioni centro) {
        this.centro = centro;
    }

    public Animale getAnimale() {
        return animale;
    }

    public void setAnimale(Animale animale) {
        this.animale = animale;
    }
}
