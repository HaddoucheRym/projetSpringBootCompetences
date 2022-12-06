package springBootCompetences.mycomp.equipes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springBootCompetences.mycomp.personnes.NiveauCompetence;
import springBootCompetences.mycomp.personnes.Personne;
import springBootCompetences.mycomp.personnes.PersonneService;
import springBootCompetences.mycomp.personnes.dto.PersonneMinimalDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public class EquipeServiceImpl implements EquipeService {

    private static final Logger logger = LoggerFactory.getLogger(EquipeServiceImpl.class);
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
        entity.setDateModification(LocalDateTime.now());
        for (Personne membre: entity.getMembres()) {
            if (membre.getId() == null) {
                this.personneService.save(membre);
            }
        }
        logger.info("Sauvegarde d'une nouvelle equipe: " + entity);
        return equipeRepository.save(entity);
    }


    @Override
    public Equipe findById(String id) {
        return equipeRepository.findById(id).orElseThrow(() -> {
            logger.warn("id invalide: "+id);
              return  new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
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

    @Override
    public List<PersonneMinimalDTO> trouverPersonneCompetenceMax(String idEquipe) {
        Equipe equipe = this.findById(idEquipe);
        List<PersonneMinimalDTO> result = new ArrayList<>();

//        PersonneMinimalDTO personneMinimalDTO = new PersonneMinimalDTO();
//        Integer niveauMax = 0;
//        NiveauCompetence competenceMax = new NiveauCompetence();
        for (Personne personne: equipe.getMembres()) {
            Optional<NiveauCompetence> niveauCompetence = personne.getCompetences().
                    stream().reduce((comp1, comp2) -> {
                        return comp1.getNiveau() > comp2.getNiveau() ? comp1 : comp2;
                    });
            List<NiveauCompetence> niveauCompetences = new ArrayList<>();
            result.add(new PersonneMinimalDTO(
                    personne.getId(),
                    personne.getNom(),
                    personne.getPrenom(),
                    niveauCompetence.get()
            ));
        }
        return result;
    }
}
