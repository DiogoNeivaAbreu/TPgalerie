package galerie.dao;

import galerie.entity.Exposition;
import galerie.entity.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public void ajouterExposition(){   
        log.info("On ajoute un nouvel enregistrement dans la table 'exposition'");
        nvlExposition = new Exposition(LocalDate.now(), "exposition1", 20);
        expositionDAO.save(nvlExposition);
        long nombre = expositionDAO.count();
        assertEquals(5, nombre, "On doit trouver 5 expositions"); 
    }
    
    @Test 
    public void CAcorrect(){
        Exposition e = new Exposition(LocalDate.now(), "expo1", 2);
        Transaction t1 = new Transaction();
        t1.setPrixVente(100);
        t1.setLieuDeVente(e);
        ArrayList<Transaction> ventes = new ArrayList();
        ventes.add(t1);
        e.setVentes(ventes);
        assertEquals(100, e.CA(), "Le CA doit être de 100");
        
        assertEquals(100, expositionDAO.chiffreAffairePour(1), "Le CA doit être de 100" );
    }
}
