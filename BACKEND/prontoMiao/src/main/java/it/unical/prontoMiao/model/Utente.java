package it.unical.prontoMiao.model;

import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    //private String fotoProfilo; lo facciamo Byte? perchè nel DB è un Varchar

    public Utente(){};

    public Utente( String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email=email;
    }

    protected String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password=password;
    }
}
