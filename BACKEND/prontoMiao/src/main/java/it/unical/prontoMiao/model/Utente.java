package it.unical.prontoMiao.model;

import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
