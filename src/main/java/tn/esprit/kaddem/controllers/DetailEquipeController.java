package tn.esprit.kaddem.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.DetailEquipe;
import tn.esprit.kaddem.services.IDetailEquipeServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/detailEquipe")
public class DetailEquipeController {

    IDetailEquipeServices detailEquipeServices;

    @PostMapping("/addDetailEquipe")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        return detailEquipeServices.addDetailEquipe(detailEquipe);
    }

    @PutMapping("/updateDetailEquipe")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        return detailEquipeServices.updateDetailEquipe(detailEquipe);
    }

    @GetMapping("/retrieveDetailEquipe/{idDetailEquipe}")
    public DetailEquipe retrieveDetailEquipe(@PathVariable("idDetailEquipe") Integer idDetailEquipe) {
        return detailEquipeServices.retrieveDetailEquipe(idDetailEquipe);
    }

    @GetMapping("/retrieveAllDetailEquipes")
    public List<DetailEquipe> retrieveAllDetailEquipes() {
        return detailEquipeServices.retrieveAllDetailEquipes();
    }

    @GetMapping("/removeDetailEquipe/{idDetailEquipe}")
    public void removeDetailEquipe(@PathVariable("idDetailEquipe") Integer idDetailEquipe) {
        detailEquipeServices.removeDetailEquipe(idDetailEquipe);
    }

}
