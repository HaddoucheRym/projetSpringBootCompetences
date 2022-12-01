package springBootCompetences.mycomp.competances;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springBootCompetences.mycomp.equipes.EquipeRepository;
import springBootCompetences.mycomp.equipes.EquipeService;
import springBootCompetences.mycomp.equipes.EquipeServiceImpl;

@Configuration
public class CompetenceConfiguration {

    @Bean
    public CompetenceService competenceService(CompetenceRepository competenceRepository) {
        return new CompetenceServiceImpl(competenceRepository);
    }
}
