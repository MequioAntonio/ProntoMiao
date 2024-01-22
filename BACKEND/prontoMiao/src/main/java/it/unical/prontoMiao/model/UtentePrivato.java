package it.unical.prontoMiao.model;

public class UtentePrivato extends Utente{

    private String nome;
    private String cf;

    private String telefono;
    private String preferenze;
    private String condizioni_abitative;
    private String informazioni_aggiuntive;

    public UtentePrivato(){
        super();
    };

    public UtentePrivato(String email, String password, String nome, String cf){
        super(email,password);
        this.nome=nome;
        this.cf=cf;
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
}
