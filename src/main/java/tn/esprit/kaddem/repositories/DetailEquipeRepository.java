package tn.esprit.kaddem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddem.entities.DetailEquipe;

@Repository
public interface DetailEquipeRepository extends CrudRepository<DetailEquipe,Integer> {
}
