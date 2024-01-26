package it.unical.prontoMiao.model;

import jakarta.persistence.*;

@Entity
@Table(name="privato")
public class UtentePrivato extends Utente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @MapsId
    private Utente utente;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;

    @Column(name = "codice_fiscale", nullable = false, unique = true)
    private String cf;

    private String telefono;
    private String indirizzo;
    private String preferenze;
    private String condizioni_abitative;
    private String informazioni_aggiuntive;

    public UtentePrivato(){
        super();
    };

    public UtentePrivato(String email, String password, String nome, String cognome, String cf, String indirizzo){
        super(email,password);
        this.nome=nome;
        this.cognome = cognome;
        this.cf=cf;
        this.indirizzo = indirizzo;
    };

    public String getNome(){
        return this.nome;
    };
    public String getCf(){
        return this.cf;
    };
    public String getTelefono(){
        return this.telefono;
    };
    public String getPreferenze(){
        return this.preferenze;
    };
    public String getCondizioni_abitative(){
        return this.condizioni_abitative;
    };
    public String getInformazioni_aggiuntive(){
        return this.informazioni_aggiuntive;
    };
    public String getIndirizzo(){
        return this.indirizzo;
    }

    public String getCognome() {
        return cognome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }
    public void setCf(String cf){
        this.cf=cf;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public void setPreferenze(String preferenze){
        this.preferenze=preferenze;
    }
    public void setCondizioni_abitative(String condizioni_abitative){
        this.condizioni_abitative=condizioni_abitative;
    }
    public void setInformazioni_aggiuntive(String informazioni_aggiuntive){
        this.informazioni_aggiuntive=informazioni_aggiuntive;
    }

    public String getPassword() {
        return super.getPassword();
    }
}
