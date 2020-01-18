package fr.epsi.asso.controler;

import fr.epsi.asso.business.AdherentManager;
import fr.epsi.asso.business.InscriptionManager;
import fr.epsi.asso.business.SeancesManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Inscription;
import fr.epsi.asso.model.Seance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MySeanceServlet")
public class MySeanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Seance> seances = new ArrayList<>();
        HttpSession session = request.getSession();
        Adherent current = (Adherent) session.getAttribute("User");

        InscriptionManager inscriptionManager = (InscriptionManager) request.getServletContext().getAttribute(InitServlet.INSCRIPTION_MANANGER);
        List<Inscription> inscriptions = inscriptionManager.getById(current.getAdherentId());
        for (Inscription i: inscriptions) {
            SeancesManager seancesManager = (SeancesManager) request.getServletContext().getAttribute(InitServlet.SEANCE_MANAGER);
            Seance s = seancesManager.getSeance(i.getSeanceId());
            seances.add(s);
        }
        session.setAttribute("seances",seances);
        request.getRequestDispatcher("/mySeances.jsp").forward(request,response);
    }
}
