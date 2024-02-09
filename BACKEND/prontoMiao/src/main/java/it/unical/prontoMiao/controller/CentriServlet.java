package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.model.CentroAdozioni;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/centro-adozioni/dammiCentri")
public class CentriServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CentroAdozioni> centri =
                null;
        try {
            centri = DBManager.getInstance().getCentroAdozioniDao().findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (CentroAdozioni c : centri){
            System.out.println(c.getNome());
        }
        req.setAttribute("lista-centri", centri);

        RequestDispatcher dispatcher = req.getRequestDispatcher("src/main/resources/templates/listaCentri.html");
        dispatcher.forward(req, resp);
    }


}
