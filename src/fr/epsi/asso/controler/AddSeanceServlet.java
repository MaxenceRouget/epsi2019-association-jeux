package fr.epsi.asso.controler;

import fr.epsi.asso.business.SeancesManager;
import fr.epsi.asso.init.InitServlet;
import fr.epsi.asso.model.Seance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddSeanceServlet")
public class AddSeanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var date = (String)request.getParameter("date");
        var hour = (String)request.getParameter("time");
        var name = (String)request.getParameter("name");

        SeancesManager seancesManager = (SeancesManager) request.getServletContext().getAttribute(InitServlet.SEANCE_MANAGER);
        var done = seancesManager.addSeance(date,hour,name);
        if(done){
            request.getRequestDispatcher("/listeSeances").forward(request,response);
        }else{
            String error = "<div class='alert alert-danger' role='alert'> Problème !  :/</div>";
            request.setAttribute("error",error);
            request.getRequestDispatcher("/listeSeances").forward(request,response);
    }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
