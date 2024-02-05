package it.unical.prontoMiao.persistenza.model;

public class CentroAdozioni {

    private Utente user;
    private String nome;
    private String descrizione;
    private String orari;
    private String eventi;
    private String indirizzo;

    public CentroAdozioni() {
    }

    public CentroAdozioni(String nome, String descrizione, String orari, String eventi, String indirizzo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.orari = orari;
        this.eventi = eventi;
        this.indirizzo = indirizzo;
    }

    public Utente getUser() {
        return user;
    }

    public void setUser(Utente user) {
        this.user = user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getOrari() {
        return orari;
    }

    public void setOrari(String orari) {
        this.orari = orari;
    }

    public String getEventi() {
        return eventi;
    }

    public void setEventi(String eventi) {
        this.eventi = eventi;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
