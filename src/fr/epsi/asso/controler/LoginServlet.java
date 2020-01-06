package fr.epsi.asso.controler;

import fr.epsi.asso.business.AdherentManager;
import fr.epsi.asso.business.SeancesManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Seance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("login");
        String mdp = request.getParameter("password");

        AdherentManager adherentManager = (AdherentManager) request.getServletContext().getAttribute(InitServlet.SEANCE_MANAGER);
        List<Adherent> adherents = adherentManager.list();

        boolean isAuthentificate = false;
        HttpSession session = request.getSession();

        for (Adherent ad: adherents) {
            if(adherents != null){
                for (Adherent u:adherents) {
                    if(u.getLogin().equals(userName) && u.getMdp().equals(mdp)){
                        session.setAttribute("User",u);
                        session.setAttribute("isAuth", (boolean)true);
                        isAuthentificate = true;
                    }
                }
            }
            if(isAuthentificate){
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
            else{
                String error = "<div class=\"alert alert-danger\" role=\"alert\"> Vous n'êtes pas connecté :/</div>";
                request.setAttribute("error",error);
                request.getRequestDispatcher("/Login.jsp").forward(request,response);
            }
        }
    }
}
