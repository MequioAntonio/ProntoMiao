package it.unical.prontoMiao.request;

public class AuthRequest {
    private String email;
    private String password;
    private String tipoUtente;
    private String nome;
    private String descrizione;
    private String orari;
    private String eventi;
    private String indirizzo;
    private String cognome;
    private String cf;
    private String telefono;
    private String preferenze;
    private String condizioni_abitative;
    private String informazioni_aggiuntive;

    public AuthRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUtente() {
        return tipoUtente;
    }

    public void setTipoUtente(String tipoUtente) {
        this.tipoUtente = tipoUtente;
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
