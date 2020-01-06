package fr.epsi.asso.business;

import fr.epsi.asso.DataAccess;
import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Seance;

import java.util.List;

public class UserManager {
    DataAccess dataAccess;

    public UserManager(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public List<Adherent> listSeances() {
        return dataAccess.listAllAdherent();
    }

    public List<Adherent> listAllAdherent(Adherent adherent) {
        return dataAccess.listAdherentForSeanceId(seance.getId());
    }
}
