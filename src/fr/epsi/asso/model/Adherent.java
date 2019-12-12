package fr.epsi.asso.model;

public class Adherent {

    private String adherentId;

    private String nom;

    public Adherent(String adherentId, String nom) {
        this.adherentId = adherentId;
        this.nom = nom;
    }

    public String getAdherentId() {
        return adherentId;
    }

    public String getNom() {
        return nom;
    }
}
