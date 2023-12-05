package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.repositories.DetailEquipeRepository;
import tn.esprit.kaddem.entities.DetailEquipe;
import java.util.List;

@Service
@AllArgsConstructor
public class DetailEquipeServicesImpl implements IDetailEquipeServices{

    DetailEquipeRepository detailEquipeRepository;

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe) {
        return detailEquipeRepository.findById(idDetailEquipe).get();
    }

    @Override
    public List<DetailEquipe> retrieveAllDetailEquipes() {
        return (List<DetailEquipe>) detailEquipeRepository.findAll();
    }

    @Override
    public void removeDetailEquipe(Integer idDetailEquipe) {
        detailEquipeRepository.deleteById(idDetailEquipe);
    }
}
