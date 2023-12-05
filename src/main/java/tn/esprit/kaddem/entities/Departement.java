package tn.esprit.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Departement implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer idDepart;
    String nomDepart;

    @OneToMany(mappedBy="departement")
    @JsonIgnore
    Set<Etudiant> etudiants;
}
