package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.model.UtentePrivato;
import it.unical.prontoMiao.persistenza.dao.UtentePrivatoDao;
import it.unical.prontoMiao.persistenza.model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UtentePrivatoDaoPostgres implements UtentePrivatoDao {

    private Connection conn;

    public UtentePrivatoDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public UtentePrivato findByEmail(String email) {
        return null;
    }

    @Override
    public UtentePrivato findById(int id) {
        return null;
    }

    @Override
    public Optional<UtentePrivato> findByEmailIgnoreCase(String email) {
        String query = "SELECT * FROM privato INNER JOIN utente ON utente.id = privato.id WHERE UPPER(utente.email) = UPPER(?)";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, email);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                UtentePrivato utente = new UtentePrivato();

                utente.setId(rs.getInt("id"));
                utente.setEmail(rs.getString("email"));
                utente.setPassword("");
                utente.setCf(rs.getString("codice_fiscale"));
                utente.setCognome(rs.getString("cognome"));
                utente.setNome(rs.getString("nome"));
                utente.setIndirizzo(rs.getString("indirizzo"));
                utente.setCondizioni_abitative(rs.getString("condizioni_abitative"));
                utente.setInformazioni_aggiuntive(rs.getString("informazioni_aggiuntive"));
                utente.setPreferenze(rs.getString("preferenze"));
                utente.setTelefono(rs.getString("telefono"));

                return Optional.of(utente);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public UtentePrivato save(UtentePrivato utente) {
        return null;
    }
}
