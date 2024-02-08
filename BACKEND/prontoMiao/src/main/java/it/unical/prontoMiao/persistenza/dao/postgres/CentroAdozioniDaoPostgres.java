package it.unical.prontoMiao.persistenza.dao.postgres;


import it.unical.prontoMiao.persistenza.IdBroker;
import it.unical.prontoMiao.persistenza.dao.CentroAdozioniDao;
import it.unical.prontoMiao.persistenza.model.CentroAdozioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CentroAdozioniDaoPostgres implements CentroAdozioniDao {

    Connection conn;

    public CentroAdozioniDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public CentroAdozioni findById(int id) throws SQLException {
        CentroAdozioni centro = null;
        String query = "select * FROM centro_adozioni ca JOIN utente u ON ca.id = u.id WHERE ca.id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            centro = new CentroAdozioni();

            centro.setEmail(rs.getString("email"));
            centro.setPassword("");
            centro.setId(rs.getInt("id"));
            centro.setDescrizione(rs.getString("descrizione"));
            centro.setEventi(rs.getString("eventi"));
            centro.setIndirizzo(rs.getString("indirizzo"));
            centro.setNome(rs.getString("nome"));
            centro.setOrari(rs.getString("orari"));
        }

        return centro;
    }

    @Override
    public List<CentroAdozioni> findAll() throws SQLException {
        List<CentroAdozioni> centri = new ArrayList<CentroAdozioni>();
        PreparedStatement st = conn.prepareStatement("select * FROM centro_adozioni ca JOIN utente u ON ca.id = u.id");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            CentroAdozioni centro = null;
            centro = new CentroAdozioni();

            centro.setEmail(rs.getString("email"));
            centro.setPassword("");
            centro.setId(rs.getInt("id"));
            centro.setDescrizione(rs.getString("descrizione"));
            centro.setEventi(rs.getString("eventi"));
            centro.setIndirizzo(rs.getString("indirizzo"));
            centro.setNome(rs.getString("nome"));
            centro.setOrari(rs.getString("orari"));
            centri.add(centro);
        }

        return centri;
    }

    @Override
    public CentroAdozioni findByEmail(String email) throws SQLException {
        CentroAdozioni centro = null;
        String query = "select * from centro_adozioni as c, utente as u where u.id=c.id and lower(u.email) = lower(?)";
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, email);

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            centro = new CentroAdozioni();

            centro.setEmail(rs.getString("email"));
            centro.setPassword("");
            centro.setId(rs.getInt("id"));
            centro.setDescrizione(rs.getString("descrizione"));
            centro.setEventi(rs.getString("eventi"));
            centro.setIndirizzo(rs.getString("indirizzo"));
            centro.setNome(rs.getString("nome"));
            centro.setOrari(rs.getString("orari"));
        }

        return centro;
    }


    @Override
    public Optional<CentroAdozioni> findByEmailIgnoreCase(String email) throws SQLException {
        CentroAdozioni centro = null;
        String query = "SELECT * FROM centro_adozioni INNER JOIN utente ON utente.id = centro_adozioni.id WHERE UPPER(utente.email) = UPPER(?)";
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, email);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            centro = new CentroAdozioni();

            centro.setEmail(rs.getString("email"));
            centro.setPassword(rs.getString("password"));
            centro.setId(rs.getInt("id"));
            centro.setDescrizione(rs.getString("descrizione"));
            centro.setEventi(rs.getString("eventi"));
            centro.setIndirizzo(rs.getString("indirizzo"));
            centro.setNome(rs.getString("nome"));
            centro.setOrari(rs.getString("orari"));
        }
        return centro == null ? Optional.empty() : Optional.of(centro);
    }


    @Override
    public CentroAdozioni save(CentroAdozioni centro) throws SQLException {
        if (centro.getId()==null){
            Integer newId = IdBroker.getId(conn);
            centro.setId(newId);

            PreparedStatement stUser = conn.prepareStatement("INSERT INTO utente (id, email, password) VALUES (?,?,?)");

            stUser.setInt(1, newId);
            stUser.setString(2, centro.getEmail());
            stUser.setString(3, centro.getPassword());

            stUser.executeUpdate();


            PreparedStatement stCentro = conn.prepareStatement("INSERT INTO centro_adozioni (id, descrizione, eventi, indirizzo, nome, orari) VALUES (?,?,?,?,?,?)");

            stCentro.setInt(1, newId);
            stCentro.setString(2, centro.getDescrizione());
            stCentro.setString(3, centro.getEventi());
            stCentro.setString(4, centro.getIndirizzo());
            stCentro.setString(5, centro.getNome());
            stCentro.setString(6, centro.getOrari());

            stCentro.executeUpdate();

        } else {
            PreparedStatement updUser = conn.prepareStatement("update utente set email=?, password=? where id=?");

            updUser.setInt(3, centro.getId());
            updUser.setString(1, centro.getEmail());
            updUser.setString(2, centro.getPassword());

            updUser.executeUpdate();

            PreparedStatement updCentro = conn.prepareStatement("update centro_adozioni set descrizione=?, eventi=?, indirizzo=?, nome=?, orari=? where id=?");

            updCentro.setInt(6, centro.getId());
            updCentro.setString(1, centro.getDescrizione());
            updCentro.setString(2, centro.getEventi());
            updCentro.setString(3, centro.getIndirizzo());
            updCentro.setString(4, centro.getNome());
            updCentro.setString(5, centro.getOrari());

        }
        return centro;
    }

    @Override
    public void delete(Integer idUtente) throws SQLException {
        PreparedStatement delCentro = conn.prepareStatement("DELETE FROM centro_adozioni WHERE id = ?");
        delCentro.setInt(1, idUtente);
        delCentro.executeUpdate();
        PreparedStatement delUser = conn.prepareStatement("DELETE FROM utente WHERE id = ?");
        delUser.setInt(1, idUtente);
        delUser.executeUpdate();
    }

}