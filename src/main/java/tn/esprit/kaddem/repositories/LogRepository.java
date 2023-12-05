package tn.esprit.kaddem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddem.entities.Log;

@Repository
public interface LogRepository extends CrudRepository<Log,Integer> {



}
