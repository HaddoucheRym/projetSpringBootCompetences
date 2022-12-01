package springBootCompetences.mycomp.personnes;

import springBootCompetences.mycomp.equipes.Equipe;

import java.util.List;

public interface PersonneService {
    List<Personne> findAll();

    Personne save(Personne entity);

    Personne findById(String id);

    void deleteById(String id);

    Personne ajoutCompetence(String idPersonne, NiveauCompetence niveauCompetence);
}
