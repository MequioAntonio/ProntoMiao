package it.unical.prontoMiao.persistenza.dao.postgres;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.unical.prontoMiao.persistenza.model.Animale;
import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.IdBroker;
import it.unical.prontoMiao.persistenza.dao.AnimaleDao;

public class AnimaleDaoPostgres implements AnimaleDao {
    Connection conn;

    public AnimaleDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Animale> getAnimali() {
        List<Animale> animali = new ArrayList<Animale>();
        String query = "select * from animale";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Animale animale = new Animale();
                animale.setId(rs.getInt("id"));
                animale.setNome(rs.getString("nome"));
                animale.setEta(rs.getInt("eta"));
                animale.setRazza(rs.getString("razza"));
                animale.setTaglia(rs.getString("taglia"));
                animale.setSpecie(rs.getString("specie"));
                animale.setSesso(rs.getString("sesso"));
                animali.add(animale);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animali;
    }

    @Override
    public List<Animale> getAnimaleByNome(String nome) {
        List<Animale> animali = new ArrayList<Animale>();
        String query = "select * from animale where nome = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nome);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Animale animale = new Animale();
                animale.setId(rs.getInt("id"));
                animale.setNome(rs.getString("nome"));
                animale.setEta(rs.getInt("eta"));
                animale.setRazza(rs.getString("razza"));
                animale.setTaglia(rs.getString("taglia"));
                animale.setSpecie(rs.getString("specie"));
                animale.setSesso(rs.getString("sesso"));
                animali.add(animale);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animali;
    }

    @Override
    public void insertAnimale(Animale animale) {
        String insertStr = "INSERT INTO animale VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement st;
        try {
            st = conn.prepareStatement(insertStr);

            Integer newId = IdBroker.getId(conn);
            animale.setId(newId);

            st.setInt(1, newId);
            st.setString(2, animale.getNome());
            st.setInt(3, animale.getEta());
            st.setString(4, animale.getRazza());
            st.setString(5, animale.getTaglia());
            st.setString(6, animale.getSpecie());
            st.setString(7, animale.getSesso());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAnimale(Animale animale) {
        String updateStr = "UPDATE animale set nome = ?, eta = ?, razza = ?, taglia = ?, specie = ?, sesso = ? where id = ?";

        PreparedStatement st;
        try {
            st = conn.prepareStatement(updateStr);

            st.setString(1, animale.getNome());
            st.setInt(2, animale.getEta());
            st.setString(3, animale.getRazza());
            st.setString(4, animale.getTaglia());
            st.setString(5, animale.getSpecie());
            st.setString(6, animale.getSesso());

            st.setInt(7, animale.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAnimale(int idAnimale) {
        String query = "DELETE FROM animale WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idAnimale);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Animale getAnimaleById(int idAnimale) {
        Animale animale = null;
        String query = "select * from animale where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idAnimale);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                animale = new Animale();
                animale.setId(rs.getInt("id"));
                animale.setNome(rs.getString("nome"));
                animale.setEta(rs.getInt("eta"));
                animale.setRazza(rs.getString("razza"));
                animale.setTaglia(rs.getString("taglia"));
                animale.setSpecie(rs.getString("specie"));
                animale.setSesso(rs.getString("sesso"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animale;
    }

    @Override
    public List<Animale> getAnimaliSenzaAnnuncio() {
        List<Animale> animaliLista = new ArrayList<Animale>();
        try {
            Statement st = conn.createStatement();
            String query = "select * from animale where id not in (select id_animale from annuncio)";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Animale animale = new Animale();
                animale.setId(rs.getInt("id"));
                animale.setNome(rs.getString("nome"));
                animale.setEta(rs.getInt("eta"));
                animale.setRazza(rs.getString("razza"));
                animale.setTaglia(rs.getString("taglia"));
                animale.setSpecie(rs.getString("specie"));
                animale.setSesso(rs.getString("sesso"));
                animaliLista.add(animale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animaliLista;
    }
}
