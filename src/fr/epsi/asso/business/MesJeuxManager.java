package fr.epsi.asso.business;

import fr.epsi.asso.DataAccess;
import fr.epsi.asso.model.Jeu;

import java.util.List;

public class MesJeuxManager {
    DataAccess dataAccess;
    public MesJeuxManager(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public List<Jeu> GetMyMist(String adherentId){
        return dataAccess.getMyGameList(adherentId);
    }

    public boolean remove(String gameId, String adherentId) {
        return dataAccess.remove(gameId, adherentId);
    }

    public boolean addToList(String adherentId, String jeuId) {
        return  dataAccess.addToList(adherentId,jeuId);
    }
}
