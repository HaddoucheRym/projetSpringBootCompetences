package springBootCompetences.mycomp.equipes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springBootCompetences.mycomp.personnes.PersonneRepository;
import springBootCompetences.mycomp.personnes.PersonneService;
import springBootCompetences.mycomp.personnes.PersonneServiceImpl;

@Configuration
public class EquipeConfiguration {

//il faut prendre Logger slf4j
    private static final Logger  logger = LoggerFactory.getLogger(EquipeConfiguration.class);


    @Bean
    public EquipeService equipeService(EquipeRepository equipeRepository, PersonneService personneService) {
        logger.info("Création du bean EquipeService");
        return new EquipeServiceImpl(equipeRepository, personneService);
    }


}
