package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.kaddem.repositories.ContratRepository;
import tn.esprit.kaddem.repositories.DepartementRepository;
import tn.esprit.kaddem.repositories.EquipeRepository;
import tn.esprit.kaddem.repositories.EtudiantRepository;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.entities.Etudiant;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService{

	EtudiantRepository etudiantRepository;
	DepartementRepository departementRepository;
	ContratRepository contratRepository;
	EquipeRepository equipeRepository;

	@Override
	public Etudiant addEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	@Override
	public Etudiant retrieveEtudiant(Integer idEtudiant) {
		return etudiantRepository.findById(idEtudiant).get();
	}

	@Override
	public List<Etudiant> retrieveAllEtudiants() {
		return (List<Etudiant>) etudiantRepository.findAll();
	}

	@Override
	public void removeEtudiant(Integer idEtudiant) {
		etudiantRepository.deleteById(idEtudiant);
	}

	@Override
	public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId){
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Departement departement = departementRepository.findById(departementId).orElse(null);
        assert etudiant != null;
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
	}

	@Override
	@Transactional
	public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe){
		Contrat c=contratRepository.findById(idContrat).orElse(null);
		Equipe eq=equipeRepository.findById(idEquipe).orElse(null);
        assert c != null;
        c.setEtudiant(e);
        assert eq != null;
        eq.getEtudiants().add(e);
		return e;
	}

	@Override
	public 	List<Etudiant> getEtudiantsByDepartement(Integer idDepartement){
		return  etudiantRepository.findEtudiantsByDepartement_IdDepart((idDepartement));
	}

}
