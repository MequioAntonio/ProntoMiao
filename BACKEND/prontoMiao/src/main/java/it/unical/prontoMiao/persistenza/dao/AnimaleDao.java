package it.unical.prontoMiao.persistenza.dao;

import it.unical.prontoMiao.persistenza.model.Animale;

import java.sql.SQLException;
import java.util.List;

public interface AnimaleDao {
    public List<Animale> findAll() throws SQLException;
    public Animale findById(Integer idAnimale) throws SQLException;
    public List<Animale> findByNome(String nome) throws SQLException;
    public Animale save(Animale animale) throws SQLException;
    public void delete(int idAnimale) throws SQLException;
    public List<Animale> findSenzaAnnuncio() throws SQLException;
    public List<Animale> findByAllLikeAsc(String nome, Integer eta, String razza, String taglia) throws SQLException;
}
