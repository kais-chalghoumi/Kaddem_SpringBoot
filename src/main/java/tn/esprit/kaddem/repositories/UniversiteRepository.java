package tn.esprit.kaddem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddem.entities.Universite;

@Repository
public interface UniversiteRepository extends CrudRepository<Universite,Integer> {
}
