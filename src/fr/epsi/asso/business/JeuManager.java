package fr.epsi.asso.business;

import fr.epsi.asso.DataAccess;
import fr.epsi.asso.model.Jeu;

import java.util.List;

public class JeuManager {
    DataAccess dataAccess;

    public JeuManager(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public List<Jeu> GetAllGames(){
        return dataAccess.GetAllGames();
    }
}
