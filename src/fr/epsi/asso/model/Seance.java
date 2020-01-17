package fr.epsi.asso.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Locale;

public class Seance {

    private String id;

    private LocalDateTime startDateTime;
    private String name;

    // pour l'exemple uniquement. devrait  être des objets représentant des inscriptions et non directement des adherents
    private List<Adherent> inscrits;

    public Seance(String id, LocalDateTime startDateTime) {
        this.id = id;
        this.startDateTime = startDateTime;
    }
    public Seance(String id, LocalDateTime startDateTime, String name) {
        this.id = id;
        this.startDateTime = startDateTime;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    public String getStartDateTimeAsString() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy à hh:mm");
        dtf.withLocale(Locale.FRANCE);
        return startDateTime.format(dtf);
    }
    public void setAdherentList(List<Adherent> inscrits) {
        this.inscrits = inscrits;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Adherent> getInscrits() {
        return inscrits;
    }
}
