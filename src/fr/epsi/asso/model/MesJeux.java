package fr.epsi.asso.model;

public class MesJeux {
        private String mesJeuxId;
        private String adherentId;
        private String jeuId;
        private String nomJeu;


    public MesJeux(String mesJeuxId, String adherentId, String jeuId) {
        this.mesJeuxId = mesJeuxId;
        this.adherentId = adherentId;
        this.jeuId = jeuId;
    }

    public MesJeux(String mesJeuxId, String adherentId, String jeuId, String nomJeu) {
        this.mesJeuxId = mesJeuxId;
        this.adherentId = adherentId;
        this.jeuId = jeuId;
        this.nomJeu = nomJeu;
    }

    public String getMesJeuxId() {
        return mesJeuxId;
    }
    public void setMesJeuxId(String mesJeuxId) {
        this.mesJeuxId = mesJeuxId;
    }
    public String getAdherentId() {
        return adherentId;
    }
    public void setAdherentId(String adherentId) {
        this.adherentId = adherentId;
    }
    public String getJeuId() {
        return jeuId;
    }
    public void setJeuId(String jeuId) {
        this.jeuId = jeuId;
    }
    public String getNomJeu() {
        return nomJeu;
    }
    public void setNomJeu(String nomJeu) {
        this.nomJeu = nomJeu;
    }
}
