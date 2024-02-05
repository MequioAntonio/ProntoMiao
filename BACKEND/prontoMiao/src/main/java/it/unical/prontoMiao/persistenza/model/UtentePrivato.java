package it.unical.prontoMiao.persistenza.model;

public class UtentePrivato {

    private Utente user;

    private String nome;
    private String cognome;
    private String cf;
    private String telefono;
    private String indirizzo;
    private String preferenze;
    private String condizioni_abitative;
    private String informazioni_aggiuntive;

    public UtentePrivato() {
    }

    public UtentePrivato(String nome, String cognome, String cf, String telefono, String indirizzo, String preferenze, String condizioni_abitative, String informazioni_aggiuntive) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
        this.preferenze = preferenze;
        this.condizioni_abitative = condizioni_abitative;
        this.informazioni_aggiuntive = informazioni_aggiuntive;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getPreferenze() {
        return preferenze;
    }

    public void setPreferenze(String preferenze) {
        this.preferenze = preferenze;
    }

    public String getCondizioni_abitative() {
        return condizioni_abitative;
    }

    public void setCondizioni_abitative(String condizioni_abitative) {
        this.condizioni_abitative = condizioni_abitative;
    }

    public String getInformazioni_aggiuntive() {
        return informazioni_aggiuntive;
    }

    public void setInformazioni_aggiuntive(String informazioni_aggiuntive) {
        this.informazioni_aggiuntive = informazioni_aggiuntive;
    }
}
