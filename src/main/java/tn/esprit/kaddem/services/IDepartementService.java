package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.Departement;
import java.util.List;
import java.util.Set;

public interface IDepartementService {

    public List<Departement> retrieveAllDepartements();

    public Departement addDepartement (Departement d);

    public   Departement updateDepartement (Departement d);

    public  Departement retrieveDepartement (Integer idDepart);

    public  void removeDepartement(Integer idDepartement);

    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite);

}
