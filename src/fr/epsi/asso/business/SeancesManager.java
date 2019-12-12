package fr.epsi.asso.business;

import fr.epsi.asso.DataAccess;
import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Seance;

import java.util.List;

public class SeancesManager {

    DataAccess dataAccess;

    public SeancesManager(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public List<Seance> listSeances() {
        return dataAccess.listAllSeances();
    }

    public List<Adherent> listAdherentsForSeance(Seance seance) {
        return dataAccess.listAdherentForSeanceId(seance.getId());
    }
}
