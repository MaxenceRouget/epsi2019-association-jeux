package fr.epsi.asso.controler;

import fr.epsi.asso.business.InscriptionManager;
import fr.epsi.asso.business.MesJeuxManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.MesJeux;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RemoveGamesServlet")
public class RemoveGamesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String gameId = request.getParameter("myIdGameToRemove");
        String adherentId = request.getParameter("myIdAdherentToRemove");

        MesJeuxManager mesJeuxManager = (MesJeuxManager) request.getServletContext().getAttribute(InitServlet.MESJEUX_MANAGER);
        boolean isOk =  mesJeuxManager.remove(gameId, adherentId);
        if(isOk){
            request.getRequestDispatcher("listeSeances").forward(request,response);
        }
        else{
            request.getRequestDispatcher("").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
