package fr.epsi.asso.business;

import fr.epsi.asso.DataAccess;
import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Seance;

import java.util.List;

public class AdherentManager {
    DataAccess dataAccess;

    public AdherentManager(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public List<Adherent> list() {
        return dataAccess.listAllAdherent();
    }

    public Adherent get(String id){
       return dataAccess.GetAdherent(id);
    }
    public boolean modifyMdp(String id, String mdp){
        return dataAccess.modifyMdp(id,mdp);
    }
}
