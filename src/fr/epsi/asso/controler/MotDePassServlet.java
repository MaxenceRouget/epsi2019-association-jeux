package fr.epsi.asso.controler;

import fr.epsi.asso.business.AdherentManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Adherent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MotDePassServlet")
public class MotDePassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newMdp = (String)request.getParameter("newpassword");
        String id = (String)session.getAttribute("UserId");

        AdherentManager adherentManager = (AdherentManager) request.getServletContext().getAttribute(InitServlet.ADHERENT_MANAGER);
        Adherent a = adherentManager.get(id);
        a.setMdp(newMdp);
        boolean isK = adherentManager.modifyMdp(id,newMdp);
        if(isK){
            request.removeAttribute("newpassword");
            request.removeAttribute("UserId");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        else{
            request.getRequestDispatcher("UpdateMdp.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
