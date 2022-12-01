package springBootCompetences.mycomp.competances;

import java.util.List;

public interface CompetenceService {
    List<Competence> findAll();

    Competence save(Competence entity);

    Competence findById(String id);

    void deleteById(String id);
}
