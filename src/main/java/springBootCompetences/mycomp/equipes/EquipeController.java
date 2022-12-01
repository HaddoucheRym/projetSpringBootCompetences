package springBootCompetences.mycomp.equipes;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/equipes")
public class EquipeController {

    private final EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    public List<Equipe> findAll() {
        return equipeService.findAll();
    }

    public Equipe save(Equipe entity) {
        return equipeService.save(entity);
    }

    public Equipe findById(String id) {
        return equipeService.findById(id);
    }

    public void deleteById(String id) {
        equipeService.deleteById(id);
    }
}
