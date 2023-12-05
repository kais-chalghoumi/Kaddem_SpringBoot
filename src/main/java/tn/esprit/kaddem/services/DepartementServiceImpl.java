package tn.esprit.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.kaddem.repositories.DepartementRepository;
import tn.esprit.kaddem.repositories.UniversiteRepository;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.entities.Universite;

import java.util.List;
import java.util.Set;

@Slf4j

@Service
public class DepartementServiceImpl implements IDepartementService{

	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	UniversiteRepository universiteRepository;

	@Override
	public Departement addDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public Departement updateDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public Departement retrieveDepartement(Integer idDepartement) {
		return departementRepository.findById(idDepartement).get();
	}

	@Override
	public List<Departement> retrieveAllDepartements() {
		return (List<Departement>) departementRepository.findAll();
	}

	@Override
	public void removeDepartement(Integer idDepartement) {
		departementRepository.deleteById(idDepartement);
	}

	@Override
	public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
		Universite universite = universiteRepository.findById(idUniversite).orElse(null);
		return universite.getDepartements();
	}


}
