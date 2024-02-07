package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.IdBroker;
import it.unical.prontoMiao.persistenza.dao.RecensioneDao;
import it.unical.prontoMiao.persistenza.model.CentroAdozioni;
import it.unical.prontoMiao.persistenza.model.Recensione;
import it.unical.prontoMiao.persistenza.model.UtentePrivato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecensioneDaoPostgres implements RecensioneDao {
    Connection conn;

    public RecensioneDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Recensione> findAll() throws SQLException {
        List<Recensione> recensioni = new ArrayList<Recensione>();
        String query = "select * from recensione";

        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Recensione rec = new Recensione();
            rec.setId(rs.getInt("id"));
            rec.setVoto(rs.getInt("voto"));
            rec.setDescrizione(rs.getString("descrizione"));

            Integer centroId = rs.getInt("id_centro");
            CentroAdozioni centro = DBManager.getInstance().getCentroAdozioniDao()
                    .findById(centroId);
            rec.setCentro(centro);

            Integer utenteId = rs.getInt("id_utente");
            UtentePrivato utente = DBManager.getInstance().getUtentePrivatoDao()
                    .findById(utenteId);
            rec.setPrivato(utente);

            recensioni.add(rec);
        }

        return recensioni;
    }

    @Override
    public Recensione findById(Integer idRecensione) throws SQLException {
        Recensione rec = null;
        String query = "select * from recensione where id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idRecensione);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            rec = new Recensione();
            rec.setId(rs.getInt("id"));
            rec.setVoto(rs.getInt("voto"));
            rec.setDescrizione(rs.getString("descrizione"));

            Integer centroId = rs.getInt("id_centro");
            CentroAdozioni centro = DBManager.getInstance().getCentroAdozioniDao()
                    .findById(centroId);
            rec.setCentro(centro);

            Integer utenteId = rs.getInt("id_utente");
            UtentePrivato utente = DBManager.getInstance().getUtentePrivatoDao()
                    .findById(utenteId);
            rec.setPrivato(utente);
        }
        return rec;
    }

    @Override
    public List<Recensione> findByCentro(Integer idCentro) throws SQLException {
        List<Recensione> recensioni = new ArrayList<Recensione>();
        String query = "select * from recensione where id_centro = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idCentro);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Recensione rec = new Recensione();
            rec.setId(rs.getInt("id"));
            rec.setVoto(rs.getInt("voto"));
            rec.setDescrizione(rs.getString("descrizione"));

            Integer centroId = rs.getInt("id_centro");
            CentroAdozioni centro = DBManager.getInstance().getCentroAdozioniDao()
                    .findById(centroId);
            rec.setCentro(centro);

            Integer utenteId = rs.getInt("id_utente");
            UtentePrivato utente = DBManager.getInstance().getUtentePrivatoDao()
                    .findById(utenteId);
            rec.setPrivato(utente);

            recensioni.add(rec);
        }

        return recensioni;
    }

    @Override
    public Recensione save(Recensione recensione) throws SQLException {
        if (recensione.getId() == null) {
            String insertStr = "INSERT INTO recensione (id, voto, descrizione, id_centro, id_utente) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement st;
            st = conn.prepareStatement(insertStr);

            Integer newId = IdBroker.getId(conn);
            recensione.setId(newId);

            st.setInt(1, newId);
            st.setInt(2, recensione.getVoto());
            st.setString(3, recensione.getDescrizione());
            st.setInt(4, recensione.getCentro().getId());
            st.setInt(5, recensione.getPrivato().getId());
            st.executeUpdate();

        } else {
            String updateStr = "UPDATE recensione set voto = ?, descrizione = ?, id_centro = ?, id_utente = ? where id = ?";

            PreparedStatement st;
            st = conn.prepareStatement(updateStr);

            st.setInt(1, recensione.getVoto());
            st.setString(2, recensione.getDescrizione());
            st.setInt(3, recensione.getCentro().getId());
            st.setInt(4, recensione.getPrivato().getId());

            st.setInt(5, recensione.getId());

            st.executeUpdate();

        }
        return recensione;

    }

    @Override
    public void delete(Integer idRecensione) throws SQLException {
        String query = "DELETE FROM recensione WHERE id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idRecensione);
        st.executeUpdate();
    }

}
