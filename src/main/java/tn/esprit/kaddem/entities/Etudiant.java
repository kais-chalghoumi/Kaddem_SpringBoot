package tn.esprit.kaddem.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer idEtudiant;
    String nomE;
    String prenomE;
    @Enumerated(EnumType.STRING)
    Option op;
    @OneToMany(mappedBy="etudiant", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Contrat> Contrats;
    @ManyToOne
    @JsonIgnore
    Departement departement;

    @ManyToMany(mappedBy="etudiants")
    @JsonIgnore
    List<Equipe> equipes ;
}
