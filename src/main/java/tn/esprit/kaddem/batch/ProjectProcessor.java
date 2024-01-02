//package tn.esprit.kaddem.batch;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.item.ItemProcessor;
//import tn.esprit.kaddem.entities.Equipe;
//import tn.esprit.kaddem.entities.Etudiant;
//
//@Slf4j
//public class ProjectProcessor implements ItemProcessor<Equipe, Equipe> {
//	@Override
//	public Equipe process(Equipe equipe) {
//		log.info("Start Batch Item Processor");
//		for (Etudiant etudiant : equipe.getEtudiants() ) {
//			etudiant.getContrats().forEach(contrat -> {
//				contrat.setMontantContrat((int) (contrat.getMontantContrat()+(contrat.getMontantContrat()*0.1)));
//			});
//
//		}
//		return equipe;
//	}
//}
