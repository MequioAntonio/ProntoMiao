package it.unical.prontoMiao.persistenza.model;

public class Animale {

    private Integer id;
    private String nome;
    private Integer eta;
    private String razza;
    private String taglia;
    private String specie;
    private String sesso;

    public Animale(){}
    public Animale(Integer id, String nome, Integer eta, String razza, String taglia, String specie, String sesso) {
        this.id = id;
        this.nome = nome;
        this.eta = eta;
        this.razza = razza;
        this.taglia = taglia;
        this.specie = specie;
        this.sesso = sesso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
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
