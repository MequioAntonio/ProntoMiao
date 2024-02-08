package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.IdBroker;
import it.unical.prontoMiao.persistenza.dao.RichiestaDao;
import it.unical.prontoMiao.persistenza.model.Annuncio;
import it.unical.prontoMiao.persistenza.model.Richiesta;
import it.unical.prontoMiao.persistenza.model.UtentePrivato;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RichiestaDaoPostgres implements RichiestaDao {

    Connection conn;

    public RichiestaDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Richiesta> findAll() throws SQLException {
        List<Richiesta> richieste = new ArrayList<Richiesta>();
        String query = "select * from richiesta";
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Richiesta ric = new Richiesta();
            ric.setId(rs.getInt("id"));
            ric.setStato(rs.getInt("stato"));
            ric.setData(rs.getDate("data"));

            Integer annuncioId = rs.getInt("id_annuncio");
            Annuncio annuncio = DBManager.getInstance().getAnnuncioDao()
                    .findById(annuncioId);
            ric.setAnnuncio(annuncio);

            Integer utenteId = rs.getInt("id_utente");
            UtentePrivato privato = DBManager.getInstance().getUtentePrivatoDao()
                    .findById(utenteId);
            ric.setUtente(privato);

            richieste.add(ric);

        }

        return richieste;
    }

    @Override
    public Richiesta findById(Integer idRichiesta) throws SQLException {
        Richiesta ric = null;
        String query = "select * from richiesta where id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idRichiesta);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            ric = new Richiesta();
            ric.setId(rs.getInt("id"));
            ric.setStato(rs.getInt("stato"));
            ric.setData(rs.getDate("data"));

            Integer annuncioId = rs.getInt("id_annuncio");
            Annuncio annuncio = DBManager.getInstance().getAnnuncioDao()
                    .findById(annuncioId);
            ric.setAnnuncio(annuncio);

            Integer utenteId = rs.getInt("id_utente");
            UtentePrivato privato = DBManager.getInstance().getUtentePrivatoDao()
                    .findById(utenteId);
            ric.setUtente(privato);
        }

        return ric;
    }

    @Override
    public Richiesta save(Richiesta richiesta) throws SQLException {
        if (richiesta.getId() == null) {
            String query = "insert into richiesta (id, stato, data, id_utente, id_annuncio) values (?, ?, ?, ? ,?)";

            PreparedStatement st;
            st = conn.prepareStatement(query);

            Integer newId = IdBroker.getId(conn);
            richiesta.setId(newId);

            st.setInt(1, newId);
            st.setInt(2, richiesta.getStato());
            st.setDate(3, richiesta.getData());
            st.setInt(4, richiesta.getUtente().getId());
            st.setInt(5, richiesta.getAnnuncio().getId());

            st.executeUpdate();

        } else {
            String query = "update richiesta set stato = ?, data = ?, id_utente = ?, id_annuncio = ? where id = ?";
            
            PreparedStatement st;
            st = conn.prepareStatement(query);

            st.setInt(1, richiesta.getStato());
            st.setDate(2, richiesta.getData());
            st.setInt(3, richiesta.getUtente().getId());
            st.setInt(4, richiesta.getAnnuncio().getId());
            
            st.setInt(5, richiesta.getId());

            st.executeUpdate();

        }
        return richiesta;

    }

    public List<Richiesta> findByAnnuncioCentro(int idCentro) throws SQLException {
        List<Richiesta> richieste = new ArrayList<>();
        String query = "select * from richiesta as r, annuncio as a where r.id_annuncio = a.id and a.id_centro = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idCentro);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Richiesta ric = new Richiesta();
            ric.setId(rs.getInt("id"));
            ric.setStato(rs.getInt("stato"));
            ric.setData(rs.getDate("data"));

            Integer annuncioId = rs.getInt("id_annuncio");
            Annuncio annuncio = DBManager.getInstance().getAnnuncioDao()
                    .findById(annuncioId);
            ric.setAnnuncio(annuncio);

            Integer utenteId = rs.getInt("id_utente");
            UtentePrivato privato = DBManager.getInstance().getUtentePrivatoDao()
                    .findById(utenteId);
            ric.setUtente(privato);

            richieste.add(ric);
        }

        return richieste;
    }

    public List<Richiesta> findByUtente(int idUtente) throws SQLException {
        List<Richiesta> richieste = new ArrayList<>();
        String query = "select * from richiesta where id_utente = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idUtente);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Richiesta ric = new Richiesta();
            ric.setId(rs.getInt("id"));
            ric.setStato(rs.getInt("stato"));
            ric.setData(rs.getDate("data"));

            Integer annuncioId = rs.getInt("id_annuncio");
            Annuncio annuncio = DBManager.getInstance().getAnnuncioDao()
                    .findById(annuncioId);
            ric.setAnnuncio(annuncio);

            Integer utenteId = rs.getInt("id_utente");
            UtentePrivato privato = DBManager.getInstance().getUtentePrivatoDao()
                    .findById(utenteId);
            ric.setUtente(privato);

            richieste.add(ric);
        }

        return richieste;
    }

    @Override
    public void delete(Integer idRichiesta) throws SQLException {
        String query = "DELETE FROM richiesta WHERE id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idRichiesta);
        st.executeUpdate();
    }
}
