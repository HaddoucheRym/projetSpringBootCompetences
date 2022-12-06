package springBootCompetences.mycomp.competances;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import springBootCompetences.mycomp.utils.Entity;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Competence extends Entity {
//    @Id
//    private String id;
    private String nom;
    private String description;

    public Competence(String id) {
        this.id = id;
    }
}
