package tn.esprit.kaddem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddem.entities.Equipe;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe,Integer> {
}
