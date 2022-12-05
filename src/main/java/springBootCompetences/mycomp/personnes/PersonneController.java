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

    @PutMapping ("{idPersonne}/competences/{idCompetence}")
    public void ajoutCompetence(@PathVariable String idPersonne,
                                @PathVariable String idCompetence,
                                      @RequestParam Integer newNiveau) {
         this.personneService.ajoutCompetence(idPersonne, idCompetence , newNiveau);
    }

    @DeleteMapping("{idPersonne}/competences")
    public void supprimeCompetence(@PathVariable String idPersonne ,
                                   @RequestParam String idCompetence) {
        this.personneService.supprimeCompetence(idPersonne,  idCompetence);
    }

    @GetMapping("competences/{idCompetence}")
    public List<Personne> affichePersonnesNiveau(@PathVariable  String idCompetence,
            @RequestParam Integer niveau){
        return this.personneService.affichePersonnesNiveau(niveau,idCompetence );
    }
}
