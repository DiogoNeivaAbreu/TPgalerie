package galerie.dao;

import galerie.entity.Exposition;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class ExpositionRepositoryTest {
    
    @Autowired
    private ExpositionRepository expositionDAO;
    
    private Exposition nvlExposition;

    @Test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Exposition'");
        int combienDansLeJeuDeTest = 4; // on a une personne et un artiste
        long nombre = expositionDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 4 expositions" );
    }
    
    @Test
    public void ajouterGalerie(){   
        
        nvlExposition = new Exposition(LocalDate.of(2021,01,15), "expo1", 2);
        expositionDAO.save(nvlExposition);
        long nombre = expositionDAO.count();
        assertEquals(5, nombre, "On doit trouver 5 expositions"); 
    }
}
