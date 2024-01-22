package it.unical.prontoMiao.model;

import org.springframework.data.annotation.Id;

public class Utente {
    @Id
    private String email;
    private String password;
    //private String fotoProfilo; lo facciamo Byte? perchè nel DB è un Varchar

    public Utente(){};
    public Utente (String email, String password){
        this.email=email;
        this.password=password;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email=email;
    }

}
