package it.unical.prontoMiao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "animale")
public class Animale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private int eta;
    private String razza;
    private String taglia;

    public Animale() {
    }

    public Animale(int id, String nome, int eta, String razza, String taglia) {
        this.id = id;
        this.nome = nome;
        this.eta = eta;
        this.razza = razza;
        this.taglia = taglia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public String getTaglia() {
        return taglia;
    }

    public void setTaglia(String taglia) {
        this.taglia = taglia;
    }
}
