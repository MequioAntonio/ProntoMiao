package it.unical.prontoMiao.persistenza.model;

public class Recensione {
    private Integer id;
    private Integer voto;
    private String descrizione;
    private CentroAdozioni centro;
    private UtentePrivato privato;

    public Recensione() {
    }

    public Recensione(Integer id, Integer voto, String descrizione, CentroAdozioni centro, UtentePrivato privato) {
        this.id = id;
        this.voto = voto;
        this.descrizione = descrizione;
        this.centro = centro;
        this.privato = privato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public CentroAdozioni getCentro() {
        return centro;
    }

    public void setCentro(CentroAdozioni centro) {
        this.centro = centro;
    }

    public UtentePrivato getPrivato() {
        return privato;
    }

    public void setPrivato(UtentePrivato privato) {
        this.privato = privato;
    }
}
