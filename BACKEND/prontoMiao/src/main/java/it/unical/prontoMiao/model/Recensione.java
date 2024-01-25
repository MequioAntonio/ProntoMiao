package it.unical.prontoMiao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recensione")
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int voto;
    private String descrizione;
    @ManyToOne//un centro può ricevere tante recensioni
    @JoinColumn(name = "id_centro")
    private CentroAdozioni centro;
    @ManyToOne//?
    @JoinColumn(name = "id_utente")
    private UtentePrivato privato;

    public Recensione() {
    }

    public Recensione(int id, int voto, String descrizione, CentroAdozioni centro, UtentePrivato privato) {
        this.id = id;
        this.voto = voto;
        this.descrizione = descrizione;
        this.centro = centro;
        this.privato = privato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
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
