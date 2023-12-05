package tn.esprit.kaddem.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer idContrat;
    @Temporal(TemporalType.DATE)
    Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    Boolean archive;
    Integer montantContrat;

    @ManyToOne(cascade = CascadeType.ALL)
    Etudiant etudiant;

}
