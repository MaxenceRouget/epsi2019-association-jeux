package fr.epsi.asso;

import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Seance;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {

    DataSource dataSource;

    public DataAccess(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Seance> listAllSeances() {

        List<Seance> seances = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM epsi.seances");
            while (rs.next()){

                String id = rs.getString("seanceId");
                Timestamp startDateTime = rs.getTimestamp("startDateTime");
                seances.add(new Seance(id, startDateTime.toLocalDateTime()));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }

    public List<Adherent> listAdherentForSeanceId(String seanceId) {

        List<Adherent> adherents = new ArrayList<>();
        String sql = "select a.nom, a.adherentId from adherents a left join inscriptions i on a.adherentId = i.adherentId where i.seanceId = ?;";
        try (Connection connection = dataSource.getConnection();PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, seanceId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                String id = rs.getString("adherentId");
                String nom = rs.getString("nom");
                String login = rs.getString("login");
                String mdp = rs.getString("mdp");
                String jeuId = rs.getString("jeuId");
                Timestamp startDateTime = rs.getTimestamp("startDateTime");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adherents;
    }

    public List<Adherent> listAllAdherent() {
        List<Adherent> adherents = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM epsi.adherents");
            while (rs.next()){

                String id = rs.getString("adherentId");
                String nom = rs.getString("nom");
                String login = rs.getString("login");
                String mdp = rs.getString("mdp");
                String jeuId = rs.getString("jeuId");
                Timestamp startDateTime = rs.getTimestamp("startDateTime");
                adherents.add(new Adherent(id,nom,login,mdp,jeuId));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adherents;
    }
}
