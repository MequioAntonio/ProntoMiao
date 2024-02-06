package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.dao.RecensioneDao;
import it.unical.prontoMiao.persistenza.model.CentroAdozioni;
import it.unical.prontoMiao.persistenza.model.Recensione;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.prontoMiao.persistenza.model.UtentePrivato;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class RecensioneDaoPostgres implements RecensioneDao {
    Connection conn;

    public RecensioneDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Recensione> getRecensione() {
        List<Recensione> recensioni = new ArrayList<Recensione>();
        String query = "select * from recensione";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Recensione rec = new Recensione();
                rec.setId(rs.getInt("id"));
                rec.setVoto(rs.getInt("voto"));
                rec.setDescrizione(rs.getString("descrizione"));

                CentroAdozioni centro = getCentroAdozioniById(rs.getInt("centro_id"));
                rec.setCentro(centro);

                UtentePrivato utente = getUtentePrivatoById(rs.getString("utente_id"));
                rec.setPrivato(utente);

                recensioni.add(rec);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recensioni;
    }

    @Override
    public Recensione getRecensioneById(Integer idRecensione) {
        Recensione rec = null;
        String query = "select * from recensione where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idRecensione);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                rec = new Recensione();
                rec.setId(rs.getInt("id"));
                rec.setVoto(rs.getInt("voto"));
                rec.setDescrizione(rs.getString("descrizione"));

                CentroAdozioni centro = getCentroAdozioniById(rs.getInt("centro_id"));
                rec.setCentro(centro);

                UtentePrivato utente = getUtentePrivatoById(rs.getString("utente_id"));
                rec.setPrivato(utente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rec;
    }

    @Override
    public List<Recensione> getRecensioniByCentro(Integer idCentro) {
        List<Recensione> recensioni = new ArrayList<Recensione>();
        String query = "select * from recensione where centro_id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idCentro);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Recensione rec = new Recensione();
                rec.setId(rs.getInt("id"));
                rec.setVoto(rs.getInt("voto"));
                rec.setDescrizione(rs.getString("descrizione"));

                CentroAdozioni centro = getCentroAdozioniById(rs.getInt("centro_id"));
                rec.setCentro(centro);

                UtentePrivato utente = getUtentePrivatoById(rs.getString("utente_id"));
                rec.setPrivato(utente);

                recensioni.add(rec);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recensioni;
    }

    @Override
    public Recensione insertRecensione(Recensione recensione) {
        String query = "insert into recensione (voto, descrizione, centro_id, utente_id) values (?, ?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, recensione.getVoto());
            st.setString(2, recensione.getDescrizione());
            st.setInt(4, recensione.getCentro().getUser().getId());
            st.setInt(5, recensione.getUtente().getUser().getId());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()){
                recensione.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recensione;
    }

    @Override
    public void deleteRecensioneById(Integer idRecensione) {
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
