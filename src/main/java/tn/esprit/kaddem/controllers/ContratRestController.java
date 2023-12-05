package tn.esprit.kaddem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.services.IContratService;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratRestController {

	IContratService contratServices;

	@PostMapping("/addContrat")
	public Contrat addContrat(@RequestBody Contrat contrat) {
		return contratServices.addContrat(contrat);
	}

	@PutMapping("/updateContrat")
	public Contrat updateContrat(@RequestBody Contrat contrat) {
		return contratServices.updateContrat(contrat);
	}

	@GetMapping("/retrieveContrat/{idContrat}")
	public Contrat retrieveContrat(@PathVariable("idContrat") Integer idContrat) {
		return contratServices.retrieveContrat(idContrat);
	}

	@GetMapping("/retrieveAllContrats")
	public List<Contrat> retrieveAllContrats() {
		return contratServices.retrieveAllContrats();
	}

	@DeleteMapping("/removeContrat/{idContrat}")
	public void removeContrat(@PathVariable("idContrat") Integer idContrat) {
		contratServices.removeContrat(idContrat);
	}

	@PutMapping("/addontratAndAffectToEtudiant/{nomE}/{prenomE}")
	public Contrat addontratAndAffectToEtudiant(@RequestBody Contrat contrat,@PathVariable("nomE") String nomE,@PathVariable("prenomE") String prenomE){
		return contratServices.addontratAndAffectToEtudiant(contrat,nomE,prenomE);
	}

	@GetMapping("/nbContratsValides/{dateDebutContrat}/{dateFinContrat}")
	public Integer nbContratsValides(@PathVariable("dateDebutContrat") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebutContrat, @PathVariable("dateFinContrat") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFinContrat){
		return contratServices.nbContratsValides(dateDebutContrat,dateFinContrat);
	}

	@GetMapping("/getChiffreAffaireEntreDeuxDate/{startDate}/{endDate}")
	@ResponseBody
	public float getChiffreAffaireEntreDeuxDate(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
		return contratServices.getChiffreAffaireEntreDeuxDates(startDate,endDate);
	}

    @Scheduled(cron="0 0 13 * * *")//(cron="0 0 13 * * ?")(fixedRate =21600)
	@PutMapping(value = "/majStatusContrat")
	public void majStatusContrat (){
		contratServices.retrieveAndUpdateStatusContrat();
	}

}


