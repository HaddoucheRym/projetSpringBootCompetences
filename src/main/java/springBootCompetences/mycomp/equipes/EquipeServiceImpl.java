package springBootCompetences.mycomp.equipes;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springBootCompetences.mycomp.personnes.Personne;
import springBootCompetences.mycomp.personnes.PersonneService;

import java.util.List;

//@Service
public class EquipeServiceImpl implements EquipeService {

    private final EquipeRepository equipeRepository;
    private final PersonneService personneService;

    public EquipeServiceImpl(EquipeRepository equipeRepository, PersonneService personneService) {
        this.equipeRepository = equipeRepository;
        this.personneService = personneService;
    }

    @Override
    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }


    @Override
    public Equipe save(Equipe entity) {
        for (Personne membre: entity.getMembres()) {
            if (membre.getId() == null) {
                this.personneService.save(membre);
            }
        }
        return equipeRepository.save(entity);
    }


    @Override
    public Equipe findById(String id) {
        return equipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @Override
    public void deleteById(String id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe ajoutMembre(String idEquipe, String idMembre) {
        Equipe equipe = this.findById(idEquipe);
        Personne membre = this.personneService.findById(idMembre);
        if (equipe.getMembres().stream().noneMatch(equipeMembre -> equipeMembre.getId().equals(idMembre))){
            equipe.getMembres().add(membre);
        }

        // <=>
//        boolean isMmembre=false;
//        for (Personne equipeMmembre: equipe.getMembres()) {
//            if (equipeMmembre.getId().equals(idMembre)){
//                isMmembre = true;
//                break;
//            }
//        }
//        if (!isMmembre) equipe.getMembres().add(membre);

        return this.save(equipe);
    }

    @Override
    public void supprimeMembre(String idEquipe, String idMembre) {
        Equipe equipe = this.findById(idEquipe);
        Personne membre = this.personneService.findById(idMembre);
        if (equipe.getMembres().stream().anyMatch(equipeMembre -> equipeMembre.getId().equals(idMembre))){
            equipe.getMembres().remove(membre);
        }

        //<=>
//        boolean isMmembre=false;
//        for (Personne equipeMmembre: equipe.getMembres()) {
//            if (equipeMmembre.getId().equals(idMembre)){
//                isMmembre = true;
//                break;
//            }
//        }
//        if (!isMmembre) equipe.getMembres().remove(membre);

        // <=>
//        equipe.getMembres().removeIf(membre1 -> membre1.getId().equals(idMembre));
        this.save(equipe);
    }
}
