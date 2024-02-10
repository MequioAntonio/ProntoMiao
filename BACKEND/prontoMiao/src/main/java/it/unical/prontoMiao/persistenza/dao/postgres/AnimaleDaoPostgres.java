package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.IdBroker;
import it.unical.prontoMiao.persistenza.dao.AnimaleDao;
import it.unical.prontoMiao.persistenza.model.Animale;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimaleDaoPostgres implements AnimaleDao {
    Connection conn;

    public AnimaleDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Animale> findAll() throws SQLException {
        List<Animale> animali = new ArrayList<Animale>();
        String query = "select * from animale";
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

        return animali;
    }

    @Override
    public List<Animale> findByNome(String nome) throws SQLException {
        List<Animale> animali = new ArrayList<Animale>();
        String query = "select * from animale where lower(nome) = lower(?)";
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, nome);

        ResultSet rs = st.executeQuery();

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

        return animali;
    }

    @Override
    public Animale save(Animale animale) throws SQLException {
        if (animale.getId() == null){
            String insertStr = "INSERT INTO animale (id, nome, eta, razza, taglia, specie, sesso) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st;
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

        } else {
            String updateStr = "UPDATE animale set nome = ?, eta = ?, razza = ?, taglia = ?, specie = ?, sesso = ? where id = ?";

            PreparedStatement st;
            st = conn.prepareStatement(updateStr);

            st.setString(1, animale.getNome());
            st.setInt(2, animale.getEta());
            st.setString(3, animale.getRazza());
            st.setString(4, animale.getTaglia());
            st.setString(5, animale.getSpecie());
            st.setString(6, animale.getSesso());

            st.setInt(7, animale.getId());

            st.executeUpdate();

        }
        return animale;

    }


    @Override
    public void delete(int idAnimale) throws SQLException {
        String query = "DELETE FROM animale WHERE id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idAnimale);
        st.executeUpdate();
    }

    @Override
    public Animale findById(Integer idAnimale) throws SQLException {
        Animale animale = null;
        String query = "select * from animale where id = ?";
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

        return animale;
    }

    @Override
    public List<Animale> findSenzaAnnuncio() throws SQLException {
        List<Animale> animaliLista = new ArrayList<Animale>();
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

        return animaliLista;
    }

    @Override
    public List<Animale> findByAllLikeAsc(String nome, Integer eta, String razza, String taglia) throws SQLException {
        List<Animale> animaliLista = new ArrayList<Animale>();
        String query = "select * from animale where (lower(nome) like lower(?)) or (eta like ?) or (lower(razza) like lower(?)) or (lower(taglia) like lower(?)) order by asc";
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, nome);
        st.setInt(2, eta);
        st.setString(3, razza);
        st.setString(4, taglia);

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

        return animaliLista;
    }
}
