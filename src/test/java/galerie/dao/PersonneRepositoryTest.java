package galerie.dao;

import galerie.entity.Personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class PersonneRepositoryTest {
    @Autowired
    private PersonneRepository personneDAO;
    private Personne nvlPersonne;

    @Test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Personne'");
        int combienDansLeJeuDeTest = 2; // on a une personne et un artiste
        long nombre = personneDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 personne" );
    }
    
    @Test
    public void ajouterGalerie(){
        nvlPersonne = new Personne("SuperG", "Castres");
        personneDAO.save(nvlPersonne);
        long nombre = personneDAO.count();
        assertEquals(3, nombre, "On doit trouver 3 personnes"); // On aura 2 personnes et un artiste
    }
}

