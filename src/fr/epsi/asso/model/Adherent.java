package fr.epsi.asso.model;

public class Adherent {

    private String adherentId;
    private String nom;
    private String login;
    private String mdp;
    private String jeu;

    public Adherent(String adherentId, String nom, String login, String mdp, String jeu) {
        this.adherentId = adherentId;
        this.nom = nom;
        this.login = login;
        this.mdp = mdp;
        this.jeu = jeu;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public String getJeu() {
        return jeu;
    }
    public void setJeu(String jeu) {
        this.jeu = jeu;
    }
    public String getAdherentId() {
        return adherentId;
    }
    public String getNom() {
        return nom;
    }
}
