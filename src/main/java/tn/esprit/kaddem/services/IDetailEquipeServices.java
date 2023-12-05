package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.DetailEquipe;
import java.util.List;

public interface IDetailEquipeServices {

    DetailEquipe addDetailEquipe (DetailEquipe detailEquipe);

    DetailEquipe updateDetailEquipe (DetailEquipe detailEquipe);

    DetailEquipe retrieveDetailEquipe (Integer idDetailEquipe);

    List<DetailEquipe> retrieveAllDetailEquipes();

    void removeDetailEquipe (Integer idDetailEquipe);

}
