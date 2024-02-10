package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.IdBroker;
import it.unical.prontoMiao.persistenza.dao.UtentePrivatoDao;
import it.unical.prontoMiao.persistenza.model.UtentePrivato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UtentePrivatoDaoPostgres implements UtentePrivatoDao {

    private Connection conn;

    public UtentePrivatoDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<UtentePrivato> findAll() throws SQLException {

        List<UtentePrivato> utentePrivati = new ArrayList<UtentePrivato>();
        String query = "select * FROM privato p JOIN utente u ON p.id = u.id;";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            UtentePrivato utentePrivato = new UtentePrivato();
            utentePrivato.setId(rs.getInt("id"));
            utentePrivato.setEmail(rs.getString("email"));
            utentePrivato.setPassword("");
            utentePrivato.setNome(rs.getString("nome"));
            utentePrivato.setCognome(rs.getString("cognome"));
            utentePrivato.setCodice_fiscale(rs.getString("codice_fiscale"));
            utentePrivato.setTelefono(rs.getString("telefono"));
            utentePrivato.setIndirizzo(rs.getString("indirizzo"));
            utentePrivato.setPreferenze(rs.getString("preferenze"));
            utentePrivato.setCondizioni_abitative(rs.getString("condizioni_abitative"));
            utentePrivato.setInformazioni_aggiuntive(rs.getString("informazioni_aggiuntive"));
            utentePrivati.add(utentePrivato);
        }

        return utentePrivati;
    }

    @Override
    public UtentePrivato findByEmail(String email) throws SQLException {
        UtentePrivato utentePrivato = null;
        String query = "select * FROM privato p JOIN utente u ON p.id = u.id and lower(u.email) = lower(?)";
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, email);

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            utentePrivato = new UtentePrivato();
            utentePrivato.setId(rs.getInt("id"));
            utentePrivato.setEmail(rs.getString("email"));
            utentePrivato.setPassword("");
            utentePrivato.setNome(rs.getString("nome"));
            utentePrivato.setCognome(rs.getString("cognome"));
            utentePrivato.setCodice_fiscale(rs.getString("codice_fiscale"));
            utentePrivato.setTelefono(rs.getString("telefono"));
            utentePrivato.setIndirizzo(rs.getString("indirizzo"));
            utentePrivato.setPreferenze(rs.getString("preferenze"));
            utentePrivato.setCondizioni_abitative(rs.getString("condizioni_abitative"));
            utentePrivato.setInformazioni_aggiuntive(rs.getString("informazioni_aggiuntive"));
        }

        return utentePrivato;
    }

    @Override
    public UtentePrivato findById(Integer id) throws SQLException {
        UtentePrivato utentePrivato = null;
        String query = "select * FROM privato p JOIN utente u ON p.id = u.id and p.id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, id);

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            utentePrivato = new UtentePrivato();
            utentePrivato.setId(rs.getInt("id"));
            utentePrivato.setEmail(rs.getString("email"));
            utentePrivato.setPassword("");
            utentePrivato.setNome(rs.getString("nome"));
            utentePrivato.setCognome(rs.getString("cognome"));
            utentePrivato.setCodice_fiscale(rs.getString("codice_fiscale"));
            utentePrivato.setTelefono(rs.getString("telefono"));
            utentePrivato.setIndirizzo(rs.getString("indirizzo"));
            utentePrivato.setPreferenze(rs.getString("preferenze"));
            utentePrivato.setCondizioni_abitative(rs.getString("condizioni_abitative"));
            utentePrivato.setInformazioni_aggiuntive(rs.getString("informazioni_aggiuntive"));
        }

        return utentePrivato;
    }

    @Override
    public Optional<UtentePrivato> findByEmailIgnoreCase(String email) {
        String query = "select * FROM privato p JOIN utente u ON p.id = u.id WHERE UPPER(u.email) = UPPER(?)";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, email);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                UtentePrivato utente = new UtentePrivato();

                utente.setId(rs.getInt("id"));
                utente.setEmail(rs.getString("email"));
                utente.setPassword(rs.getString("password"));
                utente.setCodice_fiscale(rs.getString("codice_fiscale"));
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
    public UtentePrivato save(UtentePrivato utente) throws SQLException {
        if (utente.getId() == null){
            Integer newId = IdBroker.getId(conn);
            utente.setId(newId);

            PreparedStatement stUser = conn.prepareStatement("INSERT INTO utente (id, email, password) VALUES (?,?,?)");

            stUser.setInt(1, newId);
            stUser.setString(2, utente.getEmail());
            stUser.setString(3, utente.getPassword());

            stUser.executeUpdate();


            PreparedStatement stPrivato = conn.prepareStatement("INSERT INTO privato (id, nome, cognome, codice_fiscale, telefono, indirizzo, preferenze, condizioni_abitative, informazioni_aggiuntive) VALUES (?,?,?,?,?,?,?,?,?)");

            stPrivato.setInt(1, newId);
            stPrivato.setString(2, utente.getNome());
            stPrivato.setString(3, utente.getCognome());
            stPrivato.setString(4, utente.getCodice_fiscale());
            stPrivato.setString(5, utente.getTelefono());
            stPrivato.setString(6, utente.getIndirizzo());
            stPrivato.setString(7, utente.getPreferenze());
            stPrivato.setString(8, utente.getCondizioni_abitative());
            stPrivato.setString(9, utente.getInformazioni_aggiuntive());

            stPrivato.executeUpdate();

        } else {
            PreparedStatement updUser = conn.prepareStatement("update utente set email=?, password=? where id=?");

            updUser.setInt(3, utente.getId());
            updUser.setString(1, utente.getEmail());
            updUser.setString(2, utente.getPassword());

            updUser.executeUpdate();

            PreparedStatement updPrivato = conn.prepareStatement("update privato set nome=?, cognome=?, codice_fiscale=?, telefono=?, indirizzo=?, preferenze=?, condizioni_abitative=?, informazioni_aggiuntive=? where id=?");

            updPrivato.setInt(9, utente.getId());
            updPrivato.setString(1, utente.getNome());
            updPrivato.setString(2, utente.getCognome());
            updPrivato.setString(3, utente.getCodice_fiscale());
            updPrivato.setString(4, utente.getTelefono());
            updPrivato.setString(5, utente.getIndirizzo());
            updPrivato.setString(6, utente.getPreferenze());
            updPrivato.setString(7, utente.getCondizioni_abitative());
            updPrivato.setString(8, utente.getInformazioni_aggiuntive());

        }
        return utente;
    }

    @Override
    public void deleteById(Integer idUtente) throws SQLException {
        PreparedStatement delPrivato = conn.prepareStatement("DELETE FROM privato WHERE id = ?");
        delPrivato.setInt(1, idUtente);
        delPrivato.executeUpdate();
        PreparedStatement delUser = conn.prepareStatement("DELETE FROM utente WHERE id = ?");
        delUser.setInt(1, idUtente);
        delUser.executeUpdate();
    }
}
