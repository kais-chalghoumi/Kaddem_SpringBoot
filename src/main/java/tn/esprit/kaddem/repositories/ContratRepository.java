package tn.esprit.kaddem.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddem.entities.Contrat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface ContratRepository extends CrudRepository<Contrat, Integer> {

    @Query("SELECT count(c) FROM Contrat c where ((c.archive=true) and  ((c.dateDebutContrat BETWEEN :startDate AND :endDate)) or(c.dateFinContrat BETWEEN :startDate AND :endDate))")
    public Integer getnbContratsValides(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    public List<Contrat> findAll();

    public Contrat findByIdContrat(Integer idContrat);

    Integer countByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(String nomE,String prenomE);

    Integer countByArchiveIsFalseAndDateFinContratBetween(Date dateDebutContrat, Date dateFinContrat);

    Set<Contrat> findByDateFinContratIsGreaterThanEqualAndDateFinContratIsLessThanEqual(Date startDate, Date endDate);

}
