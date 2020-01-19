package fr.epsi.asso.controler;

import fr.epsi.asso.business.AdherentManager;
import fr.epsi.asso.business.SeancesManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Seance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveSeanceServlet")
public class RemoveSeanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String seanceId = request.getParameter("removeSeanceId");
        SeancesManager seancesManager = (SeancesManager) request.getServletContext().getAttribute(InitServlet.SEANCE_MANAGER);
        boolean isOk = seancesManager.removeSeance(seanceId);

        if(isOk){
            request.getRequestDispatcher("listeSeances").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
