package fr.epsi.asso.business;

import fr.epsi.asso.DataAccess;
import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Inscription;

import java.util.List;

public class InscriptionManager {
    DataAccess dataAccess;

    public InscriptionManager(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public List<Inscription> list() {
        return dataAccess.listAllInscription();
    }
}
