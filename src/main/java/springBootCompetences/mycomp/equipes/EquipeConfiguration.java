package springBootCompetences.mycomp.equipes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springBootCompetences.mycomp.personnes.PersonneRepository;
import springBootCompetences.mycomp.personnes.PersonneService;
import springBootCompetences.mycomp.personnes.PersonneServiceImpl;

@Configuration
public class EquipeConfiguration {

    @Bean
    public EquipeService equipeService(EquipeRepository equipeRepository) {
        return new EquipeServiceImpl(equipeRepository);
    }
}
