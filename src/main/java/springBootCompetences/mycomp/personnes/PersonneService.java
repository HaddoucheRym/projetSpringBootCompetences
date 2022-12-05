package springBootCompetences.mycomp.personnes;

import springBootCompetences.mycomp.equipes.Equipe;
import springBootCompetences.mycomp.personnes.dto.PersonneMinimalDTO;

import java.util.List;

public interface PersonneService {
//    List<PersonneMinimalDTO> findAll();
      List<Personne> findAll();
    Personne save(Personne entity);

    Personne findById(String id);

    void deleteById(String id);

    /**
     * ajoute un niveau de competence à la personne
     * si cette personne posséde deja cette competence,
     * la valeur du niveau est mise a jour
     * @param idPersonne  l'id de la personne à modifier
     * @param idCompetence l'id de la competence a modifier ou ajouter
     * @param niveau le niveau de la competence
     * @return personne dont on a ajouter ou modifier sa competence
     */
    Personne ajoutCompetence(String idPersonne, String idCompetence, Integer niveau);

    /**
     * supprime la competence de la personne
     * @param idPersonne l'id de la personne a modifier
     * @param idCompetence l'id de la competence a supprimer
     */
    void supprimeCompetence(String idPersonne, String idCompetence);

    /**
     * retourne la liste des personnes possedant la competence
     * @param niveau niveau de la competence
     * @param idCompetence id de la competence
     * @return la liste des personnes possedant la competence et le niveau
     */
    List<Personne> affichePersonnesNiveau(Integer niveau,  String idCompetence);

}
