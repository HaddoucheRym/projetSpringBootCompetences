package springBootCompetences.mycomp.utils;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springBootCompetences.mycomp.competances.Competence;
import springBootCompetences.mycomp.competances.CompetenceRepository;
import springBootCompetences.mycomp.equipes.EquipeRepository;
import springBootCompetences.mycomp.personnes.PersonneRepository;

@RestController
@RequestMapping("debug")
@Profile("dev")
public class DebugController {

    private final CompetenceRepository competenceRepository;
    private final PersonneRepository personneRepository;
    private final EquipeRepository equipeRepository;

    public DebugController(CompetenceRepository competenceRepository, PersonneRepository personneRepository,
                           EquipeRepository equipeRepository) {
        this.competenceRepository = competenceRepository;
        this.personneRepository = personneRepository;
        this.equipeRepository = equipeRepository;
    }

    @DeleteMapping("clear")
    public void  clear() {
        competenceRepository.deleteAll();
        personneRepository.deleteAll();
        equipeRepository.deleteAll();
    }

    @PostMapping("init")
    public void init() {
        clear();
        Competence java = this.competenceRepository.save(new Competence("java", "un langage orienté objet"));
    }
}
