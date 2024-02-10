package it.unical.prontoMiao.persistenza.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.model.Animale;
import it.unical.prontoMiao.persistenza.model.Annuncio;
import it.unical.prontoMiao.persistenza.model.CentroAdozioni;

public class CentroAdozioniProxy extends CentroAdozioni {

    Connection conn;

    public CentroAdozioniProxy(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Annuncio> getAnnunci() throws SQLException {
        List<Annuncio> an = new ArrayList<Annuncio>();
        if (super.getAnnunci().isEmpty()) {
            String query = "select * from annuncio where id_centro = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, getId());
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

                an.add(annuncio);
            }
            super.setAnnunci(an);
            return an;
        } else {
            return super.getAnnunci();
        }

    }

}
