package springBootCompetences.mycomp.equipes;

import springBootCompetences.mycomp.personnes.dto.PersonneMinimalDTO;

import java.util.List;

public interface EquipeService {
    List<Equipe> findAll();

    Equipe save(Equipe entity);

    Equipe findById(String id);

    void deleteById(String id);

    /**
     * ajoute un membre {idMembre} à l'equipe {idEquipe}
     * @param idEquipe id de l'equipe
     * @param idMembre id de la personne qui devient membre
     * @return l'equipe avec les membres
     */
    Equipe ajoutMembre(String idEquipe, String idMembre);

    void supprimeMembre(String idEquipe, String idMembre);

    /**
     *
     * @param idEquipe
     * @return
     */
    List<PersonneMinimalDTO> trouverPersonneCompetenceMax(String idEquipe);



}
