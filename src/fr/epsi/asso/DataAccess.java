package fr.epsi.asso;

import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Inscription;
import fr.epsi.asso.model.Seance;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
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
                java.sql.Date startDate = rs.getDate("startDate");
                String startTime = rs.getString("startTime");
                SimpleDateFormat formatterBR = new SimpleDateFormat("dd/MM/YYYY");
                var dateTransformed = formatterBR.format(startDate);

                seances.add(new Seance(id, dateTransformed,startTime,name));
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

    public boolean AddNewSeance(String date, String heure, String name){
        UUID guid = UUID.randomUUID();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateTransformed = formatter.parse(date);


            java.time.LocalDate datet = LocalDate.parse(date);

            String query = " INSERT INTO seances (seanceId, startDate, startTime, name)"
                    + " values (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, guid.toString());
            preparedStmt.setDate (2, Date.valueOf(datet));
            preparedStmt.setString   (3, heure);
            preparedStmt.setString(4, name);
            boolean test = preparedStmt.execute();
            var coucou = "coucou ";
            return test == false ? true : false ;

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addNewInscription(String adherentId, String seanceId){
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            UUID guid = UUID.randomUUID();
            String query = " INSERT INTO inscriptions (inscriptionId,seanceId, adherentId)"
                    + " values (?,?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1,guid.toString());
            preparedStmt.setString (2, seanceId);
            preparedStmt.setString (3, adherentId);
            boolean test = preparedStmt.execute();
            var coucou = "coucou ";
            return test == false ? true : false ;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Inscription> getInscriptionById(String adherent) {
        List<Inscription> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM epsi.inscriptions where adherentId = '"+adherent+"'");
            while (rs.next()){
                String id = rs.getString("inscriptionId");
                String seance = rs.getString("seanceId");
                String ad = rs.getString("adherentId");
                list.add(new Inscription(id,seance,ad));
        }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Seance GetSeanceById(String seanceId) {
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM epsi.seances where seanceId = '"+seanceId+"'");
            while (rs.next()){
                String id = rs.getString("seanceId");
                String na = rs.getString("name");
                String jeuId = rs.getString("jeuId") != null ? rs.getString("jeuId") : "None";
                String date = rs.getString("startDate");
                String time = rs.getString("startTime");
                Seance s = new Seance(id,date,time,na,jeuId);
                rs.close();
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Seance();
    }
}
