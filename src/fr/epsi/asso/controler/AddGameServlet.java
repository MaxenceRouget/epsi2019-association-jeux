package fr.epsi.asso.controler;

import fr.epsi.asso.business.JeuManager;
import fr.epsi.asso.business.MesJeuxManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Jeu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddGameServlet")
public class AddGameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JeuManager jeuManager = (JeuManager) request.getServletContext().getAttribute(InitServlet.JEU_MANAGER);
        List<Jeu> jeux = jeuManager.GetAllGames();
        request.setAttribute("AddListJeu",jeux);
        request.getRequestDispatcher("/showgames.jsp").forward(request,response);
    }
}
