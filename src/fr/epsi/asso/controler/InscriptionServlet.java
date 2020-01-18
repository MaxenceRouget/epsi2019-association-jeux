package fr.epsi.asso.controler;

import fr.epsi.asso.business.AdherentManager;
import fr.epsi.asso.business.InscriptionManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Inscription;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var seanceId = (String)request.getParameter("id");
        HttpSession session = request.getSession();
        Adherent current = (Adherent) session.getAttribute("User");

        InscriptionManager inscriptionManager = (InscriptionManager) request.getServletContext().getAttribute(InitServlet.INSCRIPTION_MANANGER);
        var test = inscriptionManager.insert(current.getAdherentId(),seanceId );
        request.getRequestDispatcher("mySeances").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
