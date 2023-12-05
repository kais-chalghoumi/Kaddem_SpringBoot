package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.kaddem.repositories.ContratRepository;
import tn.esprit.kaddem.repositories.EtudiantRepository;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.entities.Specialite;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService{

	ContratRepository contratRepository;
	EtudiantRepository etudiantRepository;

	@Override
	public List<Contrat> retrieveAllContrats(){
		return contratRepository.findAll();
	}

	@Override
	public Contrat updateContrat (Contrat  ce){
		return contratRepository.save(ce);
	}

	@Override
	public  Contrat addContrat (Contrat ce){
		return contratRepository.save(ce);
	}

	@Override
	public Contrat retrieveContrat (Integer  idContrat){
		return contratRepository.findById(idContrat).orElse(null);
	}

	@Override
	public  void removeContrat(Integer idContrat){
		Contrat c=retrieveContrat(idContrat);
		contratRepository.delete(c);
	}

	@Override
	public Contrat addontratAndAffectToEtudiant (Contrat contrat, String nomE, String prenomE){
		Etudiant e=etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
		Set<Contrat> contrats= e.getContrats();
		Integer nbContratssActifs=0;
		if (contrats.size()!=0) {
			for (Contrat c : contrats) {
				if (((c.getArchive())!=null)&& ((c.getArchive())!=false))  {
					nbContratssActifs++;
				}
			}
		}
		if (nbContratssActifs<=4){
			contrat.setEtudiant(e);
		contratRepository.save(contrat);
		}
		return contrat;
	}

	@Override
	public 	Integer nbContratsValides(Date startDate, Date endDate){
		return contratRepository.getnbContratsValides(startDate, endDate);
	}

	//@Override
	//public Integer nbContratsValides(Date dateDebutContrat, Date dateFinContrat) {
	//	return contratRepository.countByArchiveIsFalseAndDateFinContratBetween(dateDebutContrat,dateFinContrat);
	//}

	@Override
	public void retrieveAndUpdateStatusContrat(){
		List<Contrat>contrats=contratRepository.findAll();
		List<Contrat>contrats15j=null;
		List<Contrat>contratsAarchiver=null;
		for (Contrat contrat : contrats) {
			Date dateSysteme = new Date();
			if (contrat.getArchive()==false) {
				long difference_In_Time = dateSysteme.getTime() - contrat.getDateFinContrat().getTime();
				long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
				if (difference_In_Days==15){
					contrats15j.add(contrat);
					log.info(" Contrat : " + contrat);
				}
				if (difference_In_Days==0) {
					contratsAarchiver.add(contrat);
					contrat.setArchive(true);
					contratRepository.save(contrat);
				}
			}
		}
	}

	@Override
	public float getChiffreAffaireEntreDeuxDates(Date startDate, Date endDate){
		float IA = 0  ;
		float RESEAUX = 0  ;
		float CLOUD = 0  ;
		float SECURITE = 0  ;
		float difference_In_Time = endDate.getTime() - startDate.getTime();
		float difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
		float difference_In_months =difference_In_Days/30;
        List<Contrat> contrats=contratRepository.findAll();
		float chiffreAffaireEntreDeuxDates=0;
		for (Contrat contrat : contrats) {
			if (contrat.getSpecialite()== Specialite.IA){
				chiffreAffaireEntreDeuxDates+=(difference_In_months*300);
				IA = IA + contrat.getMontantContrat();
			} else if (contrat.getSpecialite()== Specialite.CLOUD) {
				chiffreAffaireEntreDeuxDates+=(difference_In_months*400);
				CLOUD = CLOUD + contrat.getMontantContrat();
			}
			else if (contrat.getSpecialite()== Specialite.RESEAUX) {
				chiffreAffaireEntreDeuxDates+=(difference_In_months*350);
				RESEAUX = RESEAUX + contrat.getMontantContrat();
				}
			else //if (contrat.getSpecialite()== Specialite.SECURITE)
			 {
				 chiffreAffaireEntreDeuxDates+=(difference_In_months*450);
			}
		}
		System.out.println("Pour un contrat dont la spécialité est IA: "+IA+"Dt/mois");
		System.out.println("Pour un contrat dont la spécialité est RESEAUX: "+RESEAUX+"Dt/mois");
		System.out.println("Pour un contrat dont la spécialité est CLOUD: "+CLOUD+"Dt/mois");
		System.out.println("Pour un contrat dont la spécialité est SECURITE: "+SECURITE+"Dt/mois");

		return chiffreAffaireEntreDeuxDates;


	}


}
