package springBootCompetences.mycomp.competances;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/competences")
public class CompetenceController {

    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    public List<Competence> findAll() {
        return competenceService.findAll();
    }

    public Competence save(Competence entity) {
        return competenceService.save(entity);
    }

    public Competence findById(String id) {
        return competenceService.findById(id);
    }

    public void deleteById(String id) {
        competenceService.deleteById(id);
    }
}
