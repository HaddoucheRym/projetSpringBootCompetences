package springBootCompetences.mycomp.personnes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springBootCompetences.mycomp.personnes.NiveauCompetence;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonneMinimalDTO {
    private String id;
    private String nom;
    private String prenom;
    private NiveauCompetence niveauCompetence;
}
