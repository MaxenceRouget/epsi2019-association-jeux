package fr.epsi.asso.init;

import com.mysql.cj.jdbc.MysqlDataSource;
import fr.epsi.asso.DataAccess;
import fr.epsi.asso.business.SeancesManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InitServlet extends HttpServlet {

    public static final String SEANCE_MANAGER = "SEANCE_MANAGER";

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
        config.getServletContext().setAttribute(SEANCE_MANAGER, seancesManager);
    }
}
