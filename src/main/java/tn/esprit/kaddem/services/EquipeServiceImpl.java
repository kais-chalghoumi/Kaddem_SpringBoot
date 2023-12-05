package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.kaddem.repositories.EquipeRepository;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.entities.Niveau;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class EquipeServiceImpl implements IEquipeService{

	EquipeRepository equipeRepository;

	@Override
	public Equipe addEquipe(Equipe equipe) {
		return equipeRepository.save(equipe);
	}

	@Override
	public Equipe updateEquipe(Equipe equipe) {
		return equipeRepository.save(equipe);
	}

	@Override
	public Equipe retrieveEquipe(Integer idEquipe) {
		return equipeRepository.findById(idEquipe).get();
	}

	@Override
	public List<Equipe> retrieveAllEquipes() {
		return (List<Equipe>) equipeRepository.findAll();
	}

	@Override
	public void removeEquipe(Integer idEquipe) {
		equipeRepository.deleteById(idEquipe);
	}

	@Override
	public void evoluerEquipes(){
		List<Equipe> equipes = (List<Equipe>) equipeRepository.findAll();
		for (Equipe equipe : equipes) {
			if ((equipe.getNiveau().equals(Niveau.JUNIOR)) || (equipe.getNiveau().equals(Niveau.SENIOR))) {
				List<Etudiant> etudiants = (List<Etudiant>) equipe.getEtudiants();
				int nbEtudiantsAvecContratsActifs=0;
				for (Etudiant etudiant : etudiants) {
					Set<Contrat> contrats = etudiant.getContrats();
					for (Contrat contrat : contrats) {
						Date dateSysteme = new Date();
						long difference_In_Time = dateSysteme.getTime() - contrat.getDateFinContrat().getTime();
						long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));
						if ((!contrat.getArchive()) && (difference_In_Years > 1)) {
							nbEtudiantsAvecContratsActifs++;
							break;
						}
						if (nbEtudiantsAvecContratsActifs >= 3) break;
					}
				}
				if (nbEtudiantsAvecContratsActifs >= 3){
					if (equipe.getNiveau().equals(Niveau.JUNIOR)){
						equipe.setNiveau(Niveau.SENIOR);
						equipeRepository.save(equipe);
						break;
					}
					if (equipe.getNiveau().equals(Niveau.SENIOR)){
						equipe.setNiveau(Niveau.EXPERT);
						equipeRepository.save(equipe);
						break;
					}
				}
			}

		}

	}
}