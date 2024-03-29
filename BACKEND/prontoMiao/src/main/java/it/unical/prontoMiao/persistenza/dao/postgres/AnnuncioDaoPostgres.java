package it.unical.prontoMiao.persistenza.dao.postgres;

import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.IdBroker;
import it.unical.prontoMiao.persistenza.dao.AnnuncioDao;
import it.unical.prontoMiao.persistenza.dao.CentroAdozioniDao;
import it.unical.prontoMiao.persistenza.model.Animale;
import it.unical.prontoMiao.persistenza.model.Annuncio;
import it.unical.prontoMiao.persistenza.model.CentroAdozioni;
import it.unical.prontoMiao.utility.FileUtility;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnuncioDaoPostgres implements AnnuncioDao{
    Connection conn;

    public AnnuncioDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Annuncio> findAll() throws SQLException {
        List<Annuncio> annunci = new ArrayList<Annuncio>();
        String query = "select * from annuncio";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println(rs);

        while (rs.next()) {
            Annuncio annuncio = new Annuncio();
            annuncio.setId(rs.getInt("id"));
            annuncio.setDescrizione(rs.getString("descrizione"));
            annuncio.setInformazioni_mediche(rs.getString("informazioni_mediche"));
            annuncio.setTitolo(rs.getString("titolo"));
            annuncio.setFoto_profilo(rs.getString("foto_profilo"));

            Integer centroId = rs.getInt("id_centro");
            CentroAdozioniDao centroDao = DBManager.getInstance().getCentroAdozioniDao();
            CentroAdozioni centro = centroDao.findById(centroId);


            annuncio.setCentro(centro);

            Integer animaleId = rs.getInt("id_animale");
            Animale animale = DBManager.getInstance().getAnimaleDao()
                            .findById(animaleId);
            annuncio.setAnimale(animale);

            annunci.add(annuncio);
        }

        return annunci;
    }

    @Override
    public Annuncio findById(Integer idAnnuncio) throws SQLException {
        Annuncio annuncio = null;
        String query = "select * from annuncio where id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idAnnuncio);

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            annuncio = new Annuncio();
            annuncio.setId(rs.getInt("id"));
            annuncio.setDescrizione(rs.getString("descrizione"));
            annuncio.setInformazioni_mediche(rs.getString("informazioni_mediche"));
            annuncio.setTitolo(rs.getString("titolo"));
            annuncio.setFoto_profilo(rs.getString("foto_profilo"));

            Integer centroId = rs.getInt("id_centro");
            CentroAdozioni centro = DBManager.getInstance().getCentroAdozioniDao()
                            .findById(centroId);
            annuncio.setCentro(centro);

            Integer animaleId = rs.getInt("id_animale");
            Animale animale = DBManager.getInstance().getAnimaleDao()
                            .findById(animaleId);
            annuncio.setAnimale(animale);
        }

        return annuncio;
    }

    @Override
    public Annuncio save(Annuncio annuncio) throws SQLException, IOException {
        FileUtility fileUtility = new FileUtility();

        if (annuncio.getId() == null){

            String insertStr = "INSERT INTO annuncio (id, descrizione, informazioni_mediche, titolo, foto_profilo, id_centro, id_animale) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st;
            st = conn.prepareStatement(insertStr);

            Integer newId = IdBroker.getId(conn);
            annuncio.setId(newId);

            if (annuncio.getFoto_profilo().contains("data:image")){
                String fileEncoded = annuncio.getFoto_profilo();
                annuncio.setFoto_profilo(fileUtility.getNomeFIle(fileEncoded));

                fileUtility.base64ToFile(fileEncoded,"annuncio/"+Integer.toString(annuncio.getId()));
                annuncio.setFoto_profilo(fileUtility.generaUrlImmagine("annuncio",annuncio.getId(),annuncio.getFoto_profilo()));
            }

            st.setInt(1, newId);
            st.setString(2, annuncio.getDescrizione());
            st.setString(3, annuncio.getInformazioni_mediche());
            st.setString(4, annuncio.getTitolo());
            st.setString(5, annuncio.getFoto_profilo());
            st.setInt(6, annuncio.getCentro().getId());
            st.setInt(7, annuncio.getAnimale().getId());

            st.executeUpdate();

        } else {
            String updateStr = "UPDATE annuncio set descrizione = ?, informazioni_mediche = ?, titolo = ?, foto_profilo = ?, id_centro = ?, id_animale = ? where id = ?";

            PreparedStatement st;
            st = conn.prepareStatement(updateStr);

            if (annuncio.getFoto_profilo().contains("data:image")){
                String fileEncoded = annuncio.getFoto_profilo();
                annuncio.setFoto_profilo(fileUtility.getNomeFIle(fileEncoded));

                fileUtility.base64ToFile(fileEncoded,"annuncio/"+Integer.toString(annuncio.getId()));
                annuncio.setFoto_profilo(fileUtility.generaUrlImmagine("annuncio",annuncio.getId(),annuncio.getFoto_profilo()));
            }

            st.setString(1, annuncio.getDescrizione());
            st.setString(2, annuncio.getInformazioni_mediche());
            st.setString(3, annuncio.getTitolo());
            st.setString(4, annuncio.getFoto_profilo());
            st.setInt(5, annuncio.getCentro().getId());
            st.setInt(6, annuncio.getAnimale().getId());

            st.setInt(7, annuncio.getId());

            st.executeUpdate();

        }
        return annuncio;
    }

    @Override
    public void delete(Integer idAnnuncio) throws SQLException {
        String query = "DELETE FROM annuncio WHERE id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idAnnuncio);
        st.executeUpdate();
    }

    @Override
    public List<Annuncio> findByCentroId(Integer idCentro) throws SQLException {
        List<Annuncio> annunci = new ArrayList<Annuncio>();
        String query = "select * from annuncio where id_centro = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, idCentro);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Annuncio annuncio = new Annuncio();
            annuncio.setId(rs.getInt("id"));
            annuncio.setDescrizione(rs.getString("descrizione"));
            annuncio.setInformazioni_mediche(rs.getString("informazioni_mediche"));
            annuncio.setTitolo(rs.getString("titolo"));
            annuncio.setFoto_profilo(rs.getString("foto_profilo"));

            Integer centroId = rs.getInt("id_centro");
            CentroAdozioni centro = DBManager.getInstance().getCentroAdozioniDao()
                            .findById(centroId);
            annuncio.setCentro(centro);

            Integer animaleId = rs.getInt("id_animale");
            Animale animale = DBManager.getInstance().getAnimaleDao()
                            .findById(animaleId);
            annuncio.setAnimale(animale);

            annunci.add(annuncio);
        }

        return annunci;
    }

    @Override
    public List<Annuncio> findSenzaRichiestaAccettata() throws SQLException {
        List<Annuncio> annunciLista = new ArrayList<Annuncio>();
        Statement st = conn.createStatement();
        String query = "select * from annuncio where annuncio.id IN " +
                "(SELECT annuncio.id  FROM annuncio  EXCEPT " +
                "SELECT richiesta.id_annuncio  FROM richiesta WHERE richiesta.stato = 2)";

        ResultSet rs = st.executeQuery(query);
        while (rs.next()){
            Annuncio annuncio = new Annuncio();
            annuncio.setId(rs.getInt("id"));
            annuncio.setDescrizione(rs.getString("descrizione"));
            annuncio.setInformazioni_mediche(rs.getString("informazioni_mediche"));
            annuncio.setTitolo(rs.getString("titolo"));
            annuncio.setFoto_profilo(rs.getString("foto_profilo"));

            Integer centroId = rs.getInt("id_centro");
            CentroAdozioni centro = DBManager.getInstance().getCentroAdozioniDao()
                            .findById(centroId);
            annuncio.setCentro(centro);

            Integer animaleId = rs.getInt("id_animale");
            Animale animale = DBManager.getInstance().getAnimaleDao()
                            .findById(animaleId);
            annuncio.setAnimale(animale);

            annunciLista.add(annuncio);
        }

        return annunciLista;
    }
}
