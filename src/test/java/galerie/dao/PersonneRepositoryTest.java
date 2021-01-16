package galerie.dao;

import galerie.entity.Personne;
import galerie.entity.Tableau;
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
    public void ajouterPersonne(){
        nvlPersonne = new Personne("Pierre", "France");
        personneDAO.save(nvlPersonne);
        long nombre = personneDAO.count();
        assertEquals(3, nombre, "On doit trouver 3 personnes"); // On aura 2 personnes et un artiste
    }
    
    @Test 
    public void budgetArtCorrect(){
        Personne Pierre = new Personne("Paul", "Castres");
        // Pierre achète 2 tableaux
        Tableau t1 = new Tableau("Le beau", "toile", 60, 60);
        Transaction tr1 = new Transaction(LocalDate.of(2019,11,11), 100);
        tr1.setClient(Pierre);
        tr1.setOeuvre(t1);
        
        Tableau t2 = new Tableau("L'art", "toile", 40, 30);
        Transaction tr2 = new Transaction(LocalDate.of(2020,05,10),50);
        tr2.setClient(Pierre);
        tr2.setOeuvre(t2);
        
        ArrayList<Transaction> achats = new ArrayList();
        achats.add(tr1);
        achats.add(tr2);
        Pierre.setAchats(achats);
        
        assertEquals(50,Pierre.budgetArt(2020), "Pierre doit avoir dépensé 50€ en 2020");
        
    }
}

