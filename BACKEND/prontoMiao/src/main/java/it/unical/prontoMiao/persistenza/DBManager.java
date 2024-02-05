package it.unical.prontoMiao.persistenza;

import it.unical.prontoMiao.persistenza.dao.AnimaleDao;
import it.unical.prontoMiao.persistenza.dao.postgres.AnimaleDaoPostgres;

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
                con = DriverManager.getConnection("jdbc:postgresql://postgres.sirioshome.it:5432/public", "postgres", "homeassistant");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }

    public AnimaleDao getAnimaleDao(){
        return new AnimaleDaoPostgres(getConnection());
    }

}