package tn.esprit.kaddem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.services.IDepartementService;
import tn.esprit.kaddem.entities.Departement;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/departement")
public class DepartementRestController {

	IDepartementService departementServices;

	@PostMapping("/addDepartement")
	public Departement addDepartement(@RequestBody Departement departement) {
		return departementServices.addDepartement(departement);
	}

	@PutMapping("/updateDepartement")
	public Departement updateDepartement(@RequestBody Departement departement) {
		return departementServices.updateDepartement(departement);
	}

	@GetMapping("/retrieveDepartement/{idDepartement}")
	public Departement retrieveDepartement(@PathVariable("idDepartement") Integer idDepartement) {
		return departementServices.retrieveDepartement(idDepartement);
	}

	@GetMapping("/retrieveAllDepartements")
	public List<Departement> retrieveAllDepartements() {
		return departementServices.retrieveAllDepartements();
	}

	@DeleteMapping("/removeDepartement/{idDepartement}")
	public void removeDepartement(@PathVariable("idDepartement") Integer idDepartement) {
		departementServices.removeDepartement(idDepartement);
	}

	@PutMapping("/retrieveDepartementsByUniversite/{idUniversite}")
	public Set<Departement> retrieveDepartementsByUniversite(@PathVariable("idUniversite") Integer idUniversite){
		return departementServices.retrieveDepartementsByUniversite(idUniversite);
	}

}


