package springBootCompetences.mycomp.utils;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Entity {
    @Id
   protected String id;
   //pour assurer que la date s'initialise correctement
   protected LocalDateTime dateCreation = LocalDateTime.now();
   protected LocalDateTime dateModification = LocalDateTime.now();

}
