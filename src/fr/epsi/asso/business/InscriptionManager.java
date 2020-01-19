package fr.epsi.asso.business;

import fr.epsi.asso.DataAccess;
import fr.epsi.asso.model.Adherent;
import fr.epsi.asso.model.Inscription;

import java.util.ArrayList;
import java.util.List;

public class InscriptionManager {
    DataAccess dataAccess;

    public InscriptionManager(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public List<Inscription> list() {
        return dataAccess.listAllInscription();
    }
    public boolean insert(String adherentId, String seanceId){
        return dataAccess.addNewInscription(adherentId,seanceId);
    }
    public List<Inscription> getById(String adherentId){
        List<Inscription> list = new ArrayList<>();
        list = dataAccess.getInscriptionById(adherentId);
        return list;
    }

    public List<String> getAllAdherent(String seanceId) {
        return dataAccess.ListAdherentForSeance(seanceId);
    }

    public boolean removeInscription(String seanceId, String adherentId) {
        return dataAccess.removeInscription(seanceId, adherentId);
    }
}
