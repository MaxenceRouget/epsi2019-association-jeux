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

@WebServlet(name = "SeanceDetailServlet")
public class SeanceDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");

        InscriptionManager inscriptionManager = (InscriptionManager) request.getServletContext().getAttribute(InitServlet.INSCRIPTION_MANANGER);
        List<String> list = inscriptionManager.getAllAdherent(id);

        AdherentManager adherentManager = (AdherentManager) request.getServletContext().getAttribute(InitServlet.ADHERENT_MANAGER);
        List<Adherent> adherents = new ArrayList<>();

        SeancesManager seancesManager = (SeancesManager)request.getServletContext().getAttribute(InitServlet.SEANCE_MANAGER);
        Seance a = seancesManager.getSeance(id);

        for (String adId:list) {
           Adherent ad = adherentManager.get(adId);
           adherents.add(ad);
        }
        request.setAttribute("AdherentForSeance", adherents);
        request.setAttribute("SeanceForSeance",a);

        request.getRequestDispatcher("/detailSeance.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
