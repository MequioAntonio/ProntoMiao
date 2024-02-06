package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.dao.SegnalazioneDao;
import it.unical.prontoMiao.persistenza.model.Segnalazione;
import it.unical.prontoMiao.persistenza.model.CentroAdozioni;
import it.unical.prontoMiao.persistenza.model.UtentePrivato;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class SegnalazioneDaoPostgres implements SegnalazioneDao {
    Connection conn;

    public SegnalazioneDaoPostgres(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<Segnalazione> getSegnalazione() {
        List<Segnalazione> segnalazioni = new ArrayList<Segnalazione>();
        String query = "select * from segnalazione";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Segnalazione seg = new Segnalazione();
                seg.setId(rs.getInt("id"));
                seg.setTitolo(rs.getString("titolo"));
                seg.setDescrizione(rs.getString("descrizione"));
                seg.setIndirizzo(rs.getString("indirizzo"));

                CentroAdozioni centro = getCentroAdozioniById(rs.getInt("centro_id"));
                seg.setCentro(centro);

                UtentePrivato utente = getUtentePrivatoById(rs.getString("utente_id"));
                seg.setUtente(utente);

                segnalazioni.add(seg);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return segnalazioni;
    }
    @Override
    public Segnalazione getSegnalazioneById(int idSegnalazione) {
        Segnalazione seg = null;
        String query = "select * from segnalazione where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idSegnalazione);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                seg = new Segnalazione();
                seg.setId(rs.getInt("id"));
                seg.setTitolo(rs.getString("titolo"));
                seg.setDescrizione(rs.getString("descrizione"));
                seg.setIndirizzo(rs.getString("indirizzo"));

                CentroAdozioni centro = getCentroAdozioniById(rs.getInt("centro_id"));
                seg.setCentro(centro);

                UtentePrivato utente = getUtentePrivatoById(rs.getString("utente_id"));
                seg.setUtente(utente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return seg;
    }


    @Override
    public Segnalazione insertSegnalazione(Segnalazione segnalazione) throws IOException {
        String query = "insert into segnalazione (titolo, descrizione, indirizzo, centro_id, utente_id) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, segnalazione.getTitolo());
            st.setString(2, segnalazione.getDescrizione());
            st.setString(3, segnalazione.getIndirizzo());
            st.setInt(4, segnalazione.getCentro().getUser().getId());
            st.setInt(5, segnalazione.getUtente().getUser().getId());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()){
                segnalazione.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return segnalazione;
    }


    @Override
    public Segnalazione updateSegnalazione(int id, Segnalazione up) {
        String query = "update segnalazione set titolo = ?, descrizione = ?, indirizzo = ?, centro_id = ?, utente_id = ? where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, up.getTitolo());
            st.setString(2, up.getDescrizione());
            st.setString(3, up.getIndirizzo());
            st.setInt(4, up.getCentro().getUser().getId());
            st.setInt(5, up.getUtente().getUser().getId());
            st.setInt(6, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return up;
    }

}