package springBootCompetences.mycomp.personnes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import springBootCompetences.mycomp.competances.Competence;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NiveauCompetence {
    @DBRef
    private Competence competence;
    private Integer niveau;
}
