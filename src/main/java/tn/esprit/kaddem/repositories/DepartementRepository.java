package tn.esprit.kaddem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddem.entities.Departement;

@Repository
public interface DepartementRepository extends CrudRepository<Departement,Integer> {
}
