package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.dao.RecensioneDao;
import it.unical.prontoMiao.persistenza.model.Recensione;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class RecensioneDaoPostgres implements RecensioneDao {
    Connection conn;

    public RecensioneDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Recensione> getRecensione() {
        List<Recensione> recs = new ArrayList<Recensione>();
        String query = "select * from recensione";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Recensione rec = new Recensione();
                rec.setId(rs.getInt("id"));
                rec.setVoto(rs.getInt("voto"));
                rec.setDescrizione(rs.getString("descrizione"));
                recs.add(rec);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recs;
    }

    @Override
    public Recensione getRecensioneById(Integer id) {
        Recensione rec = null;
        String query = "select * from recensione where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                rec = new Recensione();
                rec.setId(rs.getInt("id"));
                rec.setVoto(rs.getInt("voto"));
                rec.setDescrizione(rs.getString("descrizione"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rec;
    }

    @Override
    public List<Recensione> getRecensioniByCentro(Integer idCentro) {
        List<Recensione> recs = new ArrayList<Recensione>();
        String query = "select * from recensione where centro_id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idCentro);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Recensione rec = new Recensione();
                rec.setId(rs.getInt("id"));
                rec.setVoto(rs.getInt("voto"));
                rec.setDescrizione(rs.getString("descrizione"));

                recs.add(rec);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recs;
    }

    @Override
    public Recensione insertRecensione(Recensione recensione) {
        String query = "insert into recensione (id, voto, descrizione) values (?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, recensione.getId());
            st.setInt(2, recensione.getVoto());
            st.setString(3, recensione.getDescrizione());
            int affectedRows = st.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating recensione failed, no rows affected.");
            }

            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    recensione.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating recensione failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recensione;
    }

    @Override
    public void deleteRecensioneById(Integer idRecensione){
        String query = "delete from recensione where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idRecensione);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
