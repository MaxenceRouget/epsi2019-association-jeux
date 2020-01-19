package fr.epsi.asso.model;

public class Jeu {
    private String jeuId;
    private String nom;

    public Jeu(String jeuId, String nom) {
        this.jeuId = jeuId;
        this.nom = nom;
    }

    public String getJeuId() {
        return jeuId;
    }
    public void setJeuId(String jeuId) {
        this.jeuId = jeuId;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
