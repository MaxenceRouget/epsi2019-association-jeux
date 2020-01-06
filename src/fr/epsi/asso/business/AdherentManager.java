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

}
