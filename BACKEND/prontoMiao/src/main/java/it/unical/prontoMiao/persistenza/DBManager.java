package it.unical.prontoMiao.persistenza;

import it.unical.prontoMiao.persistenza.dao.*;
import it.unical.prontoMiao.persistenza.dao.postgres.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static DBManager instance = null;

    private DBManager(){}

    public static DBManager getInstance(){
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    Connection con = null;

    public Connection getConnection(){
        if (con == null){
            try {
                con = DriverManager.getConnection("jdbc:postgresql://postgres.sirioshome.it:5432/postgres", "postgres", "homeassistant");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }

    public AnimaleDao getAnimaleDao(){
        return new AnimaleDaoPostgres(getConnection());
    }
    public AnnuncioDao getAnnuncioDao(){
        return new AnnuncioDaoPostgres(getConnection());
    }
    public CentroAdozioniDao getCentroAdozioniDao(){
        return new CentroAdozioniDaoPostgres(getConnection());
    }
    public RecensioneDao getRecensioneDao(){ return new RecensioneDaoPostgres(getConnection()); }
    public RichiestaDao getRichiestaDao(){ return new RichiestaDaoPostgres(getConnection()); }
    public SegnalazioneDao getSegnalazioneDao(){ return new SegnalazioneDaoPostgres(getConnection()); }
    public UtenteDao getUtenteDao(){ return new UtenteDaoPostgres(getConnection()); }
    public UtentePrivatoDao getUtentePrivatoDao(){ return new UtentePrivatoDaoPostgres(getConnection()); }



}