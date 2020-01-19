package fr.epsi.asso.init;

import com.mysql.cj.jdbc.MysqlDataSource;
import fr.epsi.asso.DataAccess;
import fr.epsi.asso.business.*;
import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Inscription;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;

public class InitServlet extends HttpServlet {

    public static final String SEANCE_MANAGER = "SEANCE_MANAGER";
    public static final String ADHERENT_MANAGER = "ADHERENT_MANAGER";
    public static final String INSCRIPTION_MANANGER = "INSCRIPTION_MANAGER";
    public static final String MESJEUX_MANAGER = "MESJEUX_MANAGER";
    public static final String JEU_MANAGER = "JEU_MANAGER";

    @Override
    public void init(ServletConfig config) throws ServletException {

        String jdbcUrl = config.getInitParameter("jdbcUrl");
        String password = config.getInitParameter("password");
        String user = config.getInitParameter("user");

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setPassword(password);
        dataSource.setUser(user);

        DataAccess dataAccess = new DataAccess(dataSource);
        SeancesManager seancesManager = new SeancesManager(dataAccess);
        InscriptionManager inscriptionManager = new InscriptionManager(dataAccess);
        AdherentManager adherentManager = new AdherentManager(dataAccess);
        MesJeuxManager mesJeuxManager = new MesJeuxManager(dataAccess);
        JeuManager jeuManager = new JeuManager(dataAccess);

        config.getServletContext().setAttribute(SEANCE_MANAGER, seancesManager);
        config.getServletContext().setAttribute(ADHERENT_MANAGER, adherentManager);
        config.getServletContext().setAttribute(INSCRIPTION_MANANGER,inscriptionManager);
        config.getServletContext().setAttribute(MESJEUX_MANAGER, mesJeuxManager);
        config.getServletContext().setAttribute(JEU_MANAGER, jeuManager);

    }
}
