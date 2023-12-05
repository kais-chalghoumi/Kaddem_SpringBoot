package tn.esprit.kaddem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.services.IEtudiantService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {

	IEtudiantService etudiantServices;

	@PostMapping("/addEtudiant")
	public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
		return etudiantServices.addEtudiant(etudiant);
	}

	@PutMapping("/updateEtudiant")
	public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
		return etudiantServices.updateEtudiant(etudiant);
	}

	@GetMapping("/retrieveEtudiant/{idEtudiant}")
	public Etudiant retrieveEtudiant(@PathVariable("idEtudiant") Integer idEtudiant) {
		return etudiantServices.retrieveEtudiant(idEtudiant);
	}

	@GetMapping("/retrieveAllEtudiants")
	public List<Etudiant> retrieveAllEtudiants() {
		return etudiantServices.retrieveAllEtudiants();
	}

	@DeleteMapping("/removeEtudiant/{idEtudiant}")
	public void removeEtudiant(@PathVariable("idEtudiant") Integer idEtudiant) {
		etudiantServices.removeEtudiant(idEtudiant);
	}

	@PutMapping("/assignEtudiantToDepartement/{idEtudiant}/{idDepartement}")
	public void assignEtudiantToDepartement(@PathVariable("idEtudiant") Integer idEtudiant,@PathVariable("idDepartement") Integer idDepartement){
		etudiantServices.assignEtudiantToDepartement(idEtudiant,idDepartement);
	}

	@PutMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
	public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant etudiant,@PathVariable("idContrat") Integer idContrat,@PathVariable("idEquipe") Integer idEquipe){
		return  etudiantServices.addAndAssignEtudiantToEquipeAndContract(etudiant,idContrat,idEquipe);
	}

	@PutMapping("/getEtudiantsByDepartement/{idDepartement}")
	public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepartement") Integer idDepartement){
		return etudiantServices.getEtudiantsByDepartement(idDepartement);
	}

}


