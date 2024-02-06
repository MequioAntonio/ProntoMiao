package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.dao.RecensioneDao;
import it.unical.prontoMiao.persistenza.dao.RichiestaDao;
import it.unical.prontoMiao.persistenza.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RichiestaDaoPostgres implements RichiestaDao {

    Connection conn;

    public RichiestaDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Richiesta> getRichiesta() {
        List<Richiesta> richieste = new ArrayList<Richiesta>();
        String query = "select * from richiesta";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Richiesta ric = new Richiesta();
                ric.setId(rs.getInt("id"));
                ric.setStato(rs.getInt("stato"));
                ric.setData(Date.valueOf(rs.getString("data")));

                AnnuncioDaoPostgres annuncioDao = new AnnuncioDaoPostgres(conn);
                Annuncio annuncio = annuncioDao.findById(rs.getInt("annuncio_id"));
                ric.setAnnuncio(annuncio);

                UtentePrivatoDaoPostgres utenteDao = new UtentePrivatoDaoPostgres(conn);
                UtentePrivato utente = utenteDao.findById(rs.getInt("utente_id"));
                ric.setUtente(utente);

                richieste.add(ric);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return richieste;    }

    @Override
    public Richiesta getRichiestaById(Integer idRichiesta) {
        Richiesta ric = null;
        String query = "select * from richiesta where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idRichiesta);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ric = new Richiesta();
                ric.setId(rs.getInt("id"));
                ric.setStato(rs.getInt("stato"));
                ric.setData(Date.valueOf(rs.getString("data")));
                AnnuncioDaoPostgres annuncioDao = new AnnuncioDaoPostgres(conn);
                Annuncio annuncio = annuncioDao.findById(rs.getInt("annuncio_id"));
                ric.setAnnuncio(annuncio);

                UtentePrivatoDaoPostgres utenteDao = new UtentePrivatoDaoPostgres(conn);
                UtentePrivato utente = utenteDao.findById(rs.getInt("utente_id"));
                ric.setUtente(utente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ric;
    }


    @Override
    public Richiesta insertRichieta(Richiesta richiesta) {
        String query = "insert into richiesta (id, stato, data, annuncio, utente) values (?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, richiesta.getId());
            st.setInt(2, richiesta.getStato());
            st.setString(3, richiesta.getData().toString());
            st.setInt(4, richiesta.getAnnuncio().getId());
            st.setInt(5, richiesta.getUtente().getId());
            int affectedRows = st.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating Richiesta failed, no rows affected.");
            }

            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    richiesta.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating Richiesta failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return richiesta;
    }

    public List<Richiesta> findByAnnuncio_Centro_Id(int idCentro) {
        return null;
    }

    public List<Richiesta> findByUtente_Id(int idUtente) {
        return null;
    }

    @Override
    public void deleteRichiestaById(Integer idRichiesta) {

    }
}
