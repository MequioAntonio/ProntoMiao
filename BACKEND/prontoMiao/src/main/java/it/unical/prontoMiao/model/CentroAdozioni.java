package it.unical.prontoMiao.model;

import jakarta.persistence.*;

@Entity
@Table(name="centro_adozioni")
public class CentroAdozioni extends Utente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @MapsId
    private Utente utente;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descrizione;
    @Column(nullable = false)
    private String orari;
    private String eventi;
    @Column(nullable = false)
    private String indirizzo;

    public CentroAdozioni() {
        super();
    }

    public CentroAdozioni(String email, String password, String nome, String descrizione, String orari, String eventi, String indirizzo) {
        super(email, password);
        this.nome = nome;
        this.descrizione = descrizione;
        this.orari = orari;
        this.eventi = eventi;
        this.indirizzo = indirizzo;
    }

    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
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
    public String getNome() {
        return nome;
    }
}
