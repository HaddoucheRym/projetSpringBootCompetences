package springBootCompetences.mycomp.equipes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import springBootCompetences.mycomp.personnes.Personne;
import springBootCompetences.mycomp.utils.Entity;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Equipe extends Entity {
//    @Id
//
//    private String id;
    private String nom;
    @DBRef
    private List<Personne> membres = new ArrayList<>();
}
