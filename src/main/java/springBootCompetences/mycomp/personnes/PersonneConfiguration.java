package springBootCompetences.mycomp.personnes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springBootCompetences.mycomp.competances.CompetenceService;

@Configuration
public class PersonneConfiguration {

    @Bean
    public PersonneService personneService(PersonneRepository personneRepository, ObjectMapper objectMapper, CompetenceService competenceService) {
        return new PersonneServiceImpl(personneRepository, objectMapper, competenceService);
    }
}
