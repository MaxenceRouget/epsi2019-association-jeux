package fr.epsi.asso.controler;

import fr.epsi.asso.business.AdherentManager;
import fr.epsi.asso.init.InitServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddAdherentServlet")
public class AddAdherentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String name = request.getParameter("nomAdherent");
        String login = request.getParameter("loginA");
        String mdp = request.getParameter("mdpA");
        boolean isAdmin = request.getParameter("checkAdmin") != null? true : false;

        AdherentManager adherentManager = (AdherentManager) request.getServletContext().getAttribute(InitServlet.ADHERENT_MANAGER);
        boolean isOk = adherentManager.newAdherent(name,login,mdp,isAdmin);
        request.getRequestDispatcher("listeSeances").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
