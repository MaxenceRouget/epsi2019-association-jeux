package fr.epsi.asso;

import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Inscription;
import fr.epsi.asso.model.Seance;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
                String name = rs.getString("name");
                Timestamp startDateTime = rs.getTimestamp("startDateTime");
                seances.add(new Seance(id, startDateTime.toLocalDateTime(),name));
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
          /*      String id = rs.getString("adherentId");
                String nom = rs.getString("nom");
                //String login = rs.getString("login");
                //String mdp = rs.getString("mdp");
                String jeuId = rs.getString("jeuId");
                Timestamp startDateTime = rs.getTimestamp("startDateTime");*/
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
                String admin = rs.getString("admin");
                boolean isAdmin = admin.equals("1")? true : false;
                adherents.add(new Adherent(id,nom,login,mdp,jeuId,isAdmin));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adherents;
    }

    public List<Inscription> listAllInscription(){
        List<Inscription> inscriptions = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM epsi.inscriptions");
            while (rs.next()){
                String id = rs.getString("inscriptionId");
                String seanceId = rs.getString("seanceId");
                String adherentId = rs.getString("adherentId");
                Inscription i = new Inscription(id,seanceId,adherentId);
                inscriptions.add(i);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inscriptions;
    }

    public boolean AddNewSeance(String date, String heure){
        boolean ret = false;
        UUID guid = UUID.randomUUID();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(date+" "+heure, formatter);
            int exec = stmt.executeUpdate("INSERT INTO seances VALUE ('"+guid.toString()+"','"+dateTime+"'");
            ret = exec > 0 ? true : false;
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
