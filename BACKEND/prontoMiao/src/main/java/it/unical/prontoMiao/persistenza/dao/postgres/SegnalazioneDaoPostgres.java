package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.IdBroker;
import it.unical.prontoMiao.persistenza.dao.SegnalazioneDao;
import it.unical.prontoMiao.persistenza.model.CentroAdozioni;
import it.unical.prontoMiao.persistenza.model.Segnalazione;
import it.unical.prontoMiao.persistenza.model.UtentePrivato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SegnalazioneDaoPostgres implements SegnalazioneDao {
    Connection conn;

    public SegnalazioneDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Segnalazione> findAll() throws SQLException {
        List<Segnalazione> segnalazioni = new ArrayList<Segnalazione>();
        String query = "select * from segnalazione";
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Segnalazione seg = new Segnalazione();
            seg.setId(rs.getInt("id"));
            seg.setTitolo(rs.getString("titolo"));
            seg.setDescrizione(rs.getString("descrizione"));
            seg.setIndirizzo(rs.getString("indirizzo"));

            CentroAdozioniDaoPostgres centroDao = new CentroAdozioniDaoPostgres(conn);
            CentroAdozioni centro = centroDao.findById(rs.getInt("id_centro"));
            seg.setCentro(centro);

            UtentePrivatoDaoPostgres utenteDao = new UtentePrivatoDaoPostgres(conn);
            UtentePrivato utente = utenteDao.findById(rs.getInt("id_privato"));
            seg.setUtente(utente);

            segnalazioni.add(seg);
        }

        return segnalazioni;
    }

    @Override
    public Segnalazione findById(Integer idSegnalazione) throws SQLException {
        Segnalazione seg = null;
        String query = "select * from segnalazione where id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idSegnalazione);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            seg = new Segnalazione();
            seg.setId(rs.getInt("id"));
            seg.setTitolo(rs.getString("titolo"));
            seg.setDescrizione(rs.getString("descrizione"));
            seg.setIndirizzo(rs.getString("indirizzo"));

            CentroAdozioniDaoPostgres centroDao = new CentroAdozioniDaoPostgres(conn);
            CentroAdozioni centro = centroDao.findById(rs.getInt("id_centro"));
            seg.setCentro(centro);

            UtentePrivatoDaoPostgres utenteDao = new UtentePrivatoDaoPostgres(conn);
            UtentePrivato utente = utenteDao.findById(rs.getInt("id_privato"));
            seg.setUtente(utente);
        }
        return seg;
    }

    @Override
    public Segnalazione save(Segnalazione segnalazione) throws SQLException {
        if (segnalazione.getId() == null) {
            String query = "insert into segnalazione (id, titolo, descrizione, indirizzo, id_centro, id_privato) values (?, ?, ?, ?, ?, ?)";


            PreparedStatement st = conn.prepareStatement(query);

            Integer newId = IdBroker.getId(conn);

            segnalazione.setId(newId);

            st.setInt(1, newId);
            st.setString(2, segnalazione.getTitolo());
            st.setString(3, segnalazione.getDescrizione());
            st.setString(4, segnalazione.getIndirizzo());
            if (segnalazione.getCentro() != null){
                st.setInt(5, segnalazione.getCentro().getId());
            }else {
                st.setNull(5, Types.INTEGER);
            }
            st.setInt(6, segnalazione.getUtente().getId());
            st.executeUpdate();
        } else {
            String query = "update segnalazione set titolo = ?, descrizione = ?, indirizzo = ?, id_centro = ?, id_privato = ? where id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, segnalazione.getTitolo());
            st.setString(2, segnalazione.getDescrizione());
            st.setString(3, segnalazione.getIndirizzo());
            if (segnalazione.getCentro() != null){
                st.setInt(4, segnalazione.getCentro().getId());
            }else {
                st.setNull(4, Types.INTEGER);
            }
            st.setInt(5, segnalazione.getUtente().getId());
            st.setInt(6, segnalazione.getId());
            st.executeUpdate();
        }
        return segnalazione;
    }
    @Override
    public void delete(Integer id) throws SQLException {
        String query = "delete from segnalazione where id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, id);
        st.executeUpdate();
    }
}