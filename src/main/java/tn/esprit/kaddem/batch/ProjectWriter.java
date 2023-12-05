package tn.esprit.kaddem.batch;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.entities.Log;
import tn.esprit.kaddem.repositories.LogRepository;

import java.util.List;

@Slf4j

public class ProjectWriter implements ItemWriter<Equipe> {
    @Autowired
    LogRepository logRepository;

    /* 13. écrire nos données dans la base de données*/
    public void write(List<? extends Equipe> equipes) {
        log.info("dans cette étape, nous pourrons stocker nos informations" +
                "dans une autre base de données, un fichier externe ou la meme" +
                " base de données si nous le souhaitons");
        for (Equipe equipe : equipes) {
            for (Etudiant etudiant : equipe.getEtudiants()) {
                etudiant.getContrats().forEach(contrat -> {
                    Log log = new Log();
                    log.setEtudiant(contrat.getEtudiant().getNomE());
                    log.setDateLog(contrat.getDateDebutContrat());
                    log.setNouveauMontant(contrat.getMontantContrat());
                    /* todo 7   sauvagarder les nouvelles informations (etudiant, date log, nouveau montant
                     *   dans la table log*/
                });
            }
        }
    }
}