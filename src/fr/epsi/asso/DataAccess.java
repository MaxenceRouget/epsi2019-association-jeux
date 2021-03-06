package fr.epsi.asso;

import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Inscription;
import fr.epsi.asso.model.Jeu;
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
                boolean alrad = rs.getString("alreadyConnected").equals("1") ?true:false;
                adherents.add(new Adherent(id,nom,login,mdp,jeuId,isAdmin,alrad));
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

    public List<String> ListAdherentForSeance(String seanceId) {
        List<String > list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT adherentId FROM epsi.inscriptions where seanceId = '"+seanceId+"'");
            while (rs.next()){
                String id = rs.getString("adherentId");
                list.add(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Adherent GetAdherent(String adherentId){
        Adherent a = new Adherent();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM epsi.adherents where adherentId = '"+adherentId+"'");
            while (rs.next()){
                a.setAdherentId(rs.getString("adherentId"));
                a.setNom(rs.getString("nom"));
                a.setLogin(rs.getString("login"));
                a.setMdp(rs.getString("mdp"));
                a.setAdmin( rs.getBoolean("admin"));
                a.setJeu(rs.getString("jeuId"));
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public boolean modifyMdp(String id, String mdp) {
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE adherents SET mdp = ?, alreadyConnected= ? WHERE adherentId = ? ");
            // create the mysql insert preparedstatement
            ps.setString(1,mdp);
            ps.setBoolean(2,true);
            ps.setString(3,id);

            int test = ps.executeUpdate();
            ps.close();
            return test == 1 ? true : false ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean newAdherent(String name, String login, String mdp, boolean isAdmin) {
        UUID guid = UUID.randomUUID();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            String query = " insert into adherents (adherentId, nom, login, mdp, admin, alreadyConnected)"
                    + " values (?,?,?,?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, guid.toString());
            preparedStmt.setString(2,name);
            preparedStmt.setString(3,login);
            preparedStmt.setString(4,mdp);
            preparedStmt.setBoolean(5,isAdmin);
            preparedStmt.setBoolean(6,false);

            boolean isOk = preparedStmt.execute();
            connection.close();
            return isOk == false ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Jeu> getMyGameList(String adherentId) {
        List<String> myGamesId = new ArrayList<>();
        List<Jeu> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT jeuId FROM mesjeux WHERE adherentId = '"+adherentId+"'");
            while (rs.next()){
                var JeuId = rs.getString("jeuId");
                myGamesId.add(JeuId);
            }

            for (String id: myGamesId) {
                ResultSet mesJeux = stmt.executeQuery("SELECT * FROM jeu WHERE jeuId = '"+id+"'");
                while (mesJeux.next()){
                    Jeu jeu = new Jeu(mesJeux.getString("jeuId"), mesJeux.getString("nom"));
                    list.add(jeu);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean remove(String gameId, String adherentId) {
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            String query = "DELETE FROM mesjeux where jeuId = ? AND adherentId = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1,gameId);
            preparedStmt.setString(2,adherentId);
            var isOk = preparedStmt.execute() == false ? true : false;
            connection.close();
            return isOk;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Jeu> GetAllGames(){
        List<Jeu> jeu = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM epsi.jeu");
            while (rs.next()){
                String id = rs.getString("jeuId");
                String nom = rs.getString("nom");
                jeu.add(new Jeu(id,nom));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jeu;
    }

    public boolean addToList(String adherentId, String jeuId) {
        UUID guid = UUID.randomUUID();
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            String query = " insert into mesjeux (mesjeuxId, adherentId, jeuId)"
                    + " values (?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, guid.toString());
            preparedStmt.setString(2,adherentId);
            preparedStmt.setString(3,jeuId);
            boolean isOk = preparedStmt.execute();
            connection.close();
            return isOk == false ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removeInscription(String seanceId, String adherentId) {
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            String query = "DELETE FROM inscriptions where seanceId = ? AND adherentId = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1,seanceId);
            preparedStmt.setString(2,adherentId);
            var isOk = preparedStmt.execute() == false ? true : false;
            connection.close();
            return isOk;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removeSeance(String seanceId) {
        try (Connection connection = dataSource.getConnection();Statement stmt = connection.createStatement();) {
            String query = "DELETE FROM seances where seanceId = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1,seanceId);
            var isOk = preparedStmt.execute() == false ? true : false;
            connection.close();
            return isOk;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
