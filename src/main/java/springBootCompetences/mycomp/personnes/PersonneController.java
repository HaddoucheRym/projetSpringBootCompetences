package springBootCompetences.mycomp.personnes;

import org.springframework.web.bind.annotation.*;
import springBootCompetences.mycomp.competances.Competence;
import springBootCompetences.mycomp.equipes.Equipe;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("")
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    @PostMapping("")
    public Personne save(@RequestBody Personne entity) {
        return personneService.save(entity);
    }

    @GetMapping("{id}")
    public Personne findById(@PathVariable String id) {
        return personneService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        personneService.deleteById(id);
    }

    @PostMapping("{idPersonne}/competences")
    public Personne ajoutCompetence(@PathVariable String idPersonne, @RequestBody NiveauCompetence niveauCompetence,
                                    @RequestParam (value = "idCompetence", required = false) String idCompetence ,
                                    @RequestParam (value = "niveau", required = false) Integer niveau ) {
        return this.personneService.ajoutCompetence(idPersonne, niveauCompetence);
    }
}
