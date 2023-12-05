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
public class Equipe implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer idEquipe;
    String nomEquipe;
    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @ManyToMany(cascade =CascadeType.ALL)
    @JsonIgnore
    Set<Etudiant> etudiants;

    @OneToOne
    DetailEquipe detailEquipe;

}
