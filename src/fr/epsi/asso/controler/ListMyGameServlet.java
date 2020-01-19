package fr.epsi.asso.controler;

import fr.epsi.asso.business.AdherentManager;
import fr.epsi.asso.business.MesJeuxManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Adherent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ListMyGameServlet")
public class ListMyGameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //TODO
        HttpSession session = request.getSession();
        Adherent a = (Adherent) session.getAttribute("User");

        MesJeuxManager mesJeuxManager = (MesJeuxManager) request.getServletContext().getAttribute(InitServlet.MESJEUX_MANAGER);

        var myList = mesJeuxManager.GetMyMist(a.getAdherentId());
        request.setAttribute("MyGamesList",myList);
        request.getRequestDispatcher("mygamelist.jsp").forward(request,response);
    }
}
