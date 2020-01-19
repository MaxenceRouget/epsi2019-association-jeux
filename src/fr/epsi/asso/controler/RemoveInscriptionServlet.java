package fr.epsi.asso.controler;

import fr.epsi.asso.business.AdherentManager;
import fr.epsi.asso.business.InscriptionManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Inscription;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveInscriptionServlet")
public class RemoveInscriptionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adherentId = request.getParameter("removeInscriptionAdherentId");
        String seanceId = request.getParameter("removeInscriptionSeanceId");

        InscriptionManager inscriptionManager = (InscriptionManager) request.getServletContext().getAttribute(InitServlet.INSCRIPTION_MANANGER);
        boolean isOk =  inscriptionManager.removeInscription(seanceId, adherentId);

        if(isOk){
            request.getRequestDispatcher("listeSeances").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
