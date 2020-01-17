package fr.epsi.asso.controler;

import fr.epsi.asso.business.SeancesManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Seance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListerSeanceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        SeancesManager seancesManager = (SeancesManager)request.getServletContext().getAttribute(InitServlet.SEANCE_MANAGER);
        List<Seance> seances = seancesManager.listSeances();
        request.setAttribute("seances", seances);
        request.getRequestDispatcher("seances.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SeancesManager seancesManager = (SeancesManager)request.getServletContext().getAttribute(InitServlet.SEANCE_MANAGER);
        List<Seance> seances = seancesManager.listSeances();
        request.setAttribute("seances", seances);
        request.getRequestDispatcher("seances.jsp").forward(request, response);
    }
}
