package fr.epsi.asso.controler;

import fr.epsi.asso.business.MesJeuxManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.MesJeux;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "AddJeuToMyGamesServlet")
public class AddJeuToMyGamesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Adherent current = (Adherent) session.getAttribute("User");
        var jeuId = request.getParameter("JeuToAdd");
        MesJeuxManager mesJeuxManager = (MesJeuxManager)request.getServletContext().getAttribute(InitServlet.MESJEUX_MANAGER);
        var isOk = mesJeuxManager.addToList(current.getAdherentId(),jeuId);

        if(isOk){
            request.getRequestDispatcher("listeSeances").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
