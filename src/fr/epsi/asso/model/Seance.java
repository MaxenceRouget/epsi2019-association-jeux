package fr.epsi.asso.model;

import java.sql.Time;
import java.sql.Date;

public class Seance {

    private String id;
    private String startDate;
    private String  startTime;
    private String name;
    private String jeu;

    public Seance(String startDate, String startTime, String name) {
        this.startDate = startDate;
        this.startTime = startTime;
        this.name = name;
    }

    public Seance(String id, String startDate, String startTime, String name) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
        this.name = name;
    }

    public Seance(String id, String startDate, String startTime, String name, String jeu) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
        this.name = name;
        this.jeu = jeu;
    }

    public Seance() {

    }

    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
