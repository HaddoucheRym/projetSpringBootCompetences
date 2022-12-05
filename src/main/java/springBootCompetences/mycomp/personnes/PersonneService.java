package springBootCompetences.mycomp.personnes;

import springBootCompetences.mycomp.equipes.Equipe;
import springBootCompetences.mycomp.personnes.dto.PersonneMinimalDTO;

import java.util.List;

public interface PersonneService {
    List<PersonneMinimalDTO> findAll();

    Personne save(Personne entity);

    Personne findById(String id);

    void deleteById(String id);

    Personne ajoutCompetence(String idPersonne, String idCompetence, Integer niveau);

    void supprimeCompetence(String idPersonne, Integer niveau, String idCompetence);

    List<Personne> affichePersonnesNiveau(NiveauCompetence Competence);
}
