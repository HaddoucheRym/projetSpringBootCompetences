package springBootCompetences.mycomp.equipes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import springBootCompetences.mycomp.personnes.Personne;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id
    private String id;
    private String nom;
    private List<Personne> membres = new ArrayList<>();
}
