package springBootCompetences.mycomp.personnes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import springBootCompetences.mycomp.competances.Competence;
import springBootCompetences.mycomp.competances.CompetenceService;
import springBootCompetences.mycomp.equipes.Equipe;
import springBootCompetences.mycomp.equipes.EquipeService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Service
public class PersonneServiceImpl implements PersonneService {

    private final PersonneRepository personneRepository;
    private final ObjectMapper objectMapper;

    private final CompetenceService competenceService;
//    private final EquipeService equipeService;
    private boolean iscompetence;

//    static {
//        var mapper = new ObjectMapper();
//        mapper.convertValue(new )
//    }

    public PersonneServiceImpl(PersonneRepository personneRepository, ObjectMapper objectMapper, CompetenceService competenceService) {
        this.personneRepository = personneRepository;
        this.objectMapper= objectMapper;
        this.competenceService = competenceService;
//        this.equipeService = equipeService;
    }


    @Override
//    public List<PersonneMinimalDTO> findAll() {
////        List<Personne> listPersonnes = personneRepository.findAll();
////        personneRepository.findAll(PageRequest.of(0,10));
////        <=>
//        List<Personne> listPersonnes = personneRepository.
//                findAll(PageRequest.of(0,10)).toList();
//        this.personneRepository.findAll();
//        return this.objectMapper.convertValue(listPersonnes,
//                new TypeReference<List<PersonneMinimalDTO>>() {
//                });
//        // <=>
////        List<PersonneMinimalDTO> personneMinimalDTOList = new ArrayList<>();
//
////        for (Personne personne: listPersonnes) {
//////            PersonneMinimalDTO personneMinimalDTO = new PersonneMinimalDTO();
//////            personneMinimalDTO.setNom(personne.getNom());
//////            personneMinimalDTO.setPrenom(personne.getPrenom());
//////            personneMinimalDTO.setId(personne.getId());
////            personneMinimalDTOList.add(this.objectMapper.convertValue(personne, PersonneMinimalDTO.class));
////        }
//
//        //return personneMinimalDTOList;
//
//
//    }
    public List<Personne> findAll() {
//        List<Personne> listPersonnes = personneRepository.findAll();
//        personneRepository.findAll(PageRequest.of(0,10));
//        <=>
        List<Personne> listPersonnes = personneRepository.
                findAll(PageRequest.of(0,10)).toList();
        return this.personneRepository.findAll();
        // <=>
//        List<PersonneMinimalDTO> personneMinimalDTOList = new ArrayList<>();

//        for (Personne personne: listPersonnes) {
////            PersonneMinimalDTO personneMinimalDTO = new PersonneMinimalDTO();
////            personneMinimalDTO.setNom(personne.getNom());
////            personneMinimalDTO.setPrenom(personne.getPrenom());
////            personneMinimalDTO.setId(personne.getId());
//            personneMinimalDTOList.add(this.objectMapper.convertValue(personne, PersonneMinimalDTO.class));
//        }

        //return personneMinimalDTOList;


    }


    @Override
    public Personne save(Personne entity) {
        entity.setDateModification(LocalDateTime.now());
        return personneRepository.save(entity);
    }


    @Override
    public Personne findById(String id) {
        return personneRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @Override
    public void deleteById(String id) {
        personneRepository.deleteById(id);
    }

    @Override
    public Personne ajoutCompetence(String idPersonne,
                                    String idCompetence,
                                    Integer niveau) {
        Personne personne = this.findById(idPersonne);

        Competence competence = this.competenceService.
                findById(idCompetence);
        NiveauCompetence niveauCompetence =
                new NiveauCompetence(competence, niveau);

        boolean iscompetence= false;
        for (NiveauCompetence competencePersonne:
                personne.getCompetences()) {
            if (competencePersonne.getCompetence() !=
                    null &&
                    competencePersonne.
                            getCompetence().
                            getId().equals(idCompetence)){
                System.out.println(competencePersonne);
                iscompetence = true;
                competencePersonne.setNiveau(niveau);
                System.out.println(competencePersonne);
                break;
            }
        }
        if (!iscompetence){
            personne.getCompetences().add(niveauCompetence);

        }
        return this.save(personne);
    }

    @Override
    public void supprimeCompetence(String idPersonne, String idCompetence) {
        Personne personne = this.findById(idPersonne);

        personne.getCompetences().removeIf(competence->  competence.getCompetence().getId().equals(idCompetence));

        this.save(personne);
    }

    @Override
    public List<Personne> affichePersonnesNiveau(Integer niveau, String idCompetence) {
        List<Personne> personneMinimals = this.findAll();
        List<Personne> affichesPer = new ArrayList<>();
        List<Personne> personnes = new ArrayList<>();
        for (Personne personne: personneMinimals) {
            for (NiveauCompetence niveauCompetence: personne.getCompetences()) {
                if (niveauCompetence.getCompetence() != null &&  niveauCompetence.getCompetence().getId().equals(idCompetence)){
                    if (niveauCompetence.getNiveau() > niveau) {
                        affichesPer.add(personne);
                    }
                }

            }
        }
        return affichesPer;
    }

//    @Override
//    public List<Personne> affichePersonneDEquipe(String idEquipe) {
//        Equipe equipe = this.equipeService.findById(idEquipe);
//
//        return null;
//    }
}
