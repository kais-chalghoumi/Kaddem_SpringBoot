package tn.esprit.kaddem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.services.IUniversiteService;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.entities.Universite;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

	IUniversiteService universiteServices;

	@PostMapping("/addUniversite")
	public Universite addUniversite(@RequestBody Universite universite) {
		return universiteServices.addUniversite(universite);
	}

	@PutMapping("/updateUniversite")
	public Universite updateUniversite(@RequestBody Universite universite) {
		return universiteServices.updateUniversite(universite);
	}

	@GetMapping("/retrieveUniversite/{idUniversite}")
	public Universite retrieveUniversite(@PathVariable("idUniversite") Integer idUniversite) {
		return universiteServices.retrieveUniversite(idUniversite);
	}

	@GetMapping("/retrieveAllUniversites")
	public List<Universite> retrieveAllUniversites() {
		return universiteServices.retrieveAllUniversites();
	}

	@DeleteMapping("/removeUniversite/{idUniversite}")
	public void removeUniversite(@PathVariable("idUniversite") Integer idUniversite) {
		universiteServices.removeUniversite(idUniversite);
	}

	@PutMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
	public void assignUniversiteToDepartement(@PathVariable("idUniversite") Integer idUniversite,@PathVariable("idDepartement") Integer idDepartement){
		universiteServices.assignUniversiteToDepartement(idUniversite,idDepartement);
	}

	@GetMapping(value = "/listerDepartementsUniversite/{idUniversite}")
	public Set<Departement> listerDepartementsUniversite(@PathVariable("idUniversite") Integer idUniversite) {
		return universiteServices.retrieveDepartementsByUniversite(idUniversite);
	}

}


