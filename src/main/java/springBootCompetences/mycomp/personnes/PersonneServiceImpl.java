package springBootCompetences.mycomp.personnes;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springBootCompetences.mycomp.equipes.Equipe;
import springBootCompetences.mycomp.personnes.dto.PersonneMinimalDTO;

import java.util.List;
import java.util.Optional;

//@Service
public class PersonneServiceImpl implements PersonneService {

    private final PersonneRepository personneRepository;

    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }


    @Override
    public List<Personne> findAll() {
        List<Personne> listPersonnes = personneRepository.findAll();
        List<PersonneMinimalDTO> personneMinimalDTOList = List.of();
        for (Personne personne: listPersonnes) {
            PersonneMinimalDTO personneMinimalDTO = new PersonneMinimalDTO();
            personneMinimalDTO.setNom(personne.getNom());
            personneMinimalDTO.setPrenom(personne.getPrenom());
            personneMinimalDTO.setId(personne.getId());
            personneMinimalDTOList.add(personneMinimalDTO);
        }
        return personneMinimalDTOList;
    }


    @Override
    public Personne save(Personne entity) {
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
    public Personne ajoutCompetence(String idPersonne, NiveauCompetence niveauCompetence) {
        Personne personne = this.findById(idPersonne);

        if (personne.getCompetences().stream().noneMatch(personneCompetence -> personneCompetence.getCompetence().equals(niveauCompetence.getCompetence()))){
            personne.getCompetences().add(niveauCompetence);
        }

//                boolean iscompetence=false;
//        for (NiveauCompetence competencePersonne: personne.getCompetences()) {
//            if (competencePersonne.getId().equals(idMembre)){
//                isMmembre = true;
//                break;
//            }
//        }
//        if (!isMmembre) equipe.getMembres().add(membre);


        return this.save(personne);


    }
}
