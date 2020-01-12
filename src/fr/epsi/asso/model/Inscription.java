package fr.epsi.asso.model;

public class Inscription {
    public String inscriptionId;
    private String seanceId;
    private String adherentId;

    public Inscription(String inscriptionId, String seanceId, String adherentId) {
        this.inscriptionId = inscriptionId;
        this.seanceId = seanceId;
        this.adherentId = adherentId;
    }
    public Inscription() {
    }

    public String getInscriptionId() {
        return inscriptionId;
    }
    public void setInscriptionId(String inscriptionId) {
        this.inscriptionId = inscriptionId;
    }
    public String getSeanceId() {
        return seanceId;
    }
    public void setSeanceId(String seanceId) {
        this.seanceId = seanceId;
    }
    public String getAdherentId() {
        return adherentId;
    }
    public void setAdherentId(String adherentId) {
        this.adherentId = adherentId;
    }
}
