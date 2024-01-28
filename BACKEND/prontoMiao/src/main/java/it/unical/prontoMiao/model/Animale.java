package it.unical.prontoMiao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "animale")
public class Animale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private int eta;
    @Column(nullable = false)
    private String razza;
    @Column(nullable = false)
    private String taglia;
    @Column(nullable = false)
    private String specie;
    @Column(nullable = false)
    private String sesso;

    public Animale() {
    }

    public Animale(int id, String nome, int eta, String razza, String taglia, String specie, String sesso) {
        this.id = id;
        this.nome = nome;
        this.eta = eta;
        this.razza = razza;
        this.taglia = taglia;
        this.specie = specie;
        this.sesso = sesso;
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

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }
}
