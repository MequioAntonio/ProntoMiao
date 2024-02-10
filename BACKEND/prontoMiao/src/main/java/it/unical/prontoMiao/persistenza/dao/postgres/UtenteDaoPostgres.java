package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.dao.UtenteDao;
import it.unical.prontoMiao.persistenza.model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UtenteDaoPostgres implements UtenteDao{

    Connection conn;

    public UtenteDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Optional<Utente> findByEmailIgnoreCase(String email) throws SQLException {
        String query = "SELECT * FROM utente WHERE UPPER(utente.email) = UPPER(?)";

        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, email);

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            Utente utente = new Utente();
            utente.setId(rs.getInt("id"));
            utente.setEmail(rs.getString("email"));
            utente.setPassword(rs.getString("password"));

            return Optional.of(utente);

        }


        return Optional.empty();
    }
}
