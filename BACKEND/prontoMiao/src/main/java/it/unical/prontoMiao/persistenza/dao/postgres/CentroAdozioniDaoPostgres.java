package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.model_old.CentroAdozioni;
import it.unical.prontoMiao.persistenza.dao.CentroAdozioniDao;
import it.unical.prontoMiao.persistenza.model.Recensione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CentroAdozioniDaoPostgres implements CentroAdozioniDao {

    Connection conn;

    public CentroAdozioniDaoPostgres(Connection conn) {
        this.conn = conn;
    }
    @Override
    public CentroAdozioni findCentroById(int id) {
        CentroAdozioni centro = null;
        String query = "SELECT * FROM centro_adozioni INNER JOIN utente ON utente.id = centro_adozioni.id WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                centro = new CentroAdozioni();

                centro.setEmail(rs.getString("email"));
                centro.setId(rs.getInt("id"));
                centro.setDescrizione(rs.getString("descrizione"));
                centro.setEventi(rs.getString("eventi"));
                centro.setIndirizzo(rs.getString("indirizzo"));
                centro.setNome(rs.getString("nome"));
                centro.setOrari(rs.getString("orari"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return centro;
    }

    @Override
    public Optional<CentroAdozioni> findByEmailIgnoreCase(String email) {
        return Optional.empty();
    }
}
