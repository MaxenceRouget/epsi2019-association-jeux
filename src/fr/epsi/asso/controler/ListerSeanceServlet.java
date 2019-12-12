package fr.epsi.asso.controler;

import fr.epsi.asso.business.SeancesManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Seance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListerSeanceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        SeancesManager seancesManager = (SeancesManager)request.getServletContext().getAttribute(InitServlet.SEANCE_MANAGER);
        List<Seance> seances = seancesManager.listSeances();
        seances.forEach(seance -> seance.setAdherentList(seancesManager.listAdherentsForSeance(seance)));
        request.setAttribute("seances", seances);
        request.getRequestDispatcher("seances.jsp").forward(request, response);
    }

}
