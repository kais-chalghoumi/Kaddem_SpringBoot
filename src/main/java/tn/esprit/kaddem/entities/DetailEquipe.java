package tn.esprit.kaddem.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailEquipe implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer idDetailEquipe;
    Integer salle;
    String thematique;

    @OneToOne(mappedBy="detailEquipe")
    Equipe equipe;
}
