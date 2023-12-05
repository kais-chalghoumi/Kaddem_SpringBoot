package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.repositories.DepartementRepository;
import tn.esprit.kaddem.repositories.UniversiteRepository;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.entities.Universite;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{

    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public List<Universite> retrieveAllUniversites() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement){
        Universite u= universiteRepository.findById(idUniversite).orElse(null);
        Departement d= departementRepository.findById(idDepartement).orElse(null);
        if (u != null && d != null){
            u.getDepartements().add(d);
            universiteRepository.save(u);
        }
    }

    @Override
    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite){
    Universite u=universiteRepository.findById(idUniversite).orElse(null);
        assert u != null;
        return u.getDepartements();
    }

}
