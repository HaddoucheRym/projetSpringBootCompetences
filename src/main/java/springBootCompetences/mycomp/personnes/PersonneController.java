package springBootCompetences.mycomp.personnes;

import org.springframework.web.bind.annotation.*;
import springBootCompetences.mycomp.competances.Competence;
import springBootCompetences.mycomp.equipes.Equipe;
import springBootCompetences.mycomp.personnes.dto.PersonneMinimalDTO;

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
    public List<PersonneMinimalDTO> findAll() {
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

    @PutMapping ("{idPersonne}/competences/{idCompetence}/niveau/{newniveau}")
    public void ajoutCompetence(@PathVariable String idPersonne,@PathVariable String idCompetence,
                                      @PathVariable Integer newniveau) {
         this.personneService.ajoutCompetence(idPersonne, idCompetence , newniveau);
    }

    @DeleteMapping("{idPersonne}/competences")
    public void supprimeCompetence(@PathVariable String idPersonne , @RequestParam Integer niveau,
                                   @RequestParam String idCompetence) {
        this.personneService.supprimeCompetence(idPersonne, niveau, idCompetence);
    }
}
