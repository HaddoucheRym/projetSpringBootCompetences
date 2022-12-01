package springBootCompetences.mycomp.competances;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetenceRepository extends MongoRepository<Competence, String> {
}
