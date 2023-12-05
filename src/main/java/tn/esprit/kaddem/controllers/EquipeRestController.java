package tn.esprit.kaddem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.services.IEquipeService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {

	IEquipeService equipeServices;

	@PostMapping("/addEquipe")
	public Equipe addEquipe(@RequestBody Equipe equipe) {
		return equipeServices.addEquipe(equipe);
	}

	@PutMapping("/updateEquipe")
	public Equipe updateEquipe(@RequestBody Equipe equipe) {
		return equipeServices.updateEquipe(equipe);
	}

	@GetMapping("/retrieveEquipe/{idEquipe}")
	public Equipe retrieveEquipe(@PathVariable("idEquipe") Integer idEquipe) {
		return equipeServices.retrieveEquipe(idEquipe);
	}

	@GetMapping("/retrieveAllEquipes")
	public List<Equipe> retrieveAllEquipes() {
		return equipeServices.retrieveAllEquipes();
	}

	@DeleteMapping("/removeEquipe/{idEquipe}")
	public void removeEquipe(@PathVariable("idEquipe") Integer idEquipe) {
		equipeServices.removeEquipe(idEquipe);
	}

	@Scheduled(cron="0 0 13 * * *")
	@PutMapping("/faireEvoluerEquipes")
	public void faireEvoluerEquipes() {
		 equipeServices.evoluerEquipes() ;
	}

}


