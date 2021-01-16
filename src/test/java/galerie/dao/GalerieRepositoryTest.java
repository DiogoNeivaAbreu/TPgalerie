package galerie.dao;

import galerie.entity.Galerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import galerie.entity.Exposition;
import galerie.entity.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class GalerieRepositoryTest {

    @Autowired
    private GalerieRepository galerieDAO;
    private Galerie nvlGalerie, nvlGalerie2 ;

    @Test
//    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Galerie'");
        int combienDansLeJeuDeTest = 1; 
        long nombre = galerieDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 galerie" );
    }
    
    @Test
//    @Sql("test-data.sql")
    public void ajouterGalerie(){
        nvlGalerie = new Galerie("SuperG", "Castres");
        galerieDAO.save(nvlGalerie);
        long nombre = galerieDAO.count();
        assertEquals(2, nombre, "On doit trouver 2 galeries"); // L'ajout a bien été effectué
        
        nvlGalerie2 = new Galerie("SuperG", "Castres");
        
        try { 
            galerieDAO.save(nvlGalerie2);
            fail("Les galeries doivent être différentes, on doit avoir une exception");
        } catch (DataIntegrityViolationException e) {
                    // Si on arrive ici c'est normal, on a eu l'exception attendue
            }
        assertEquals(2, nombre, "On doit trouver 2 galeries"); // L'ajout ne s'est pas fait
   
    }
    
    @Test
    public void CAannuelcorrect(){
        Galerie galerie = new Galerie("SuperG", "Castres");
        Exposition e = new Exposition(LocalDate.of(2020,11,05), "exposition1", 20);
        Exposition e2 = new Exposition(LocalDate.of(2020,05,05), "exposition2", 20);
        Exposition e3 = new Exposition(LocalDate.of(2019,05,05), "exposition2", 20);
        // cette expo ne sera pas comptabilisé pour 2020 mais pour 2019
        
        // On ajoute les expositions à la galerie 
        ArrayList<Exposition> evenements = new ArrayList();
        evenements.add(e);
        evenements.add(e2);
        evenements.add(e3);
        galerie.setEvenements(evenements);
        
        Transaction t1 = new Transaction(LocalDate.of(2020,11,05),100);
        t1.setLieuDeVente(e);
        Transaction t2 = new Transaction(LocalDate.of(2020,05,05),60);
        t2.setLieuDeVente(e2);
        Transaction t3 = new Transaction(LocalDate.of(2019,05,05),200);
        t3.setLieuDeVente(e3);
        
        // On ajoute les différente transaction pour les expositions
        ArrayList<Transaction> ventes = new ArrayList();
        ventes.add(t1);
        e.setVentes(ventes);
        ArrayList<Transaction> ventes2 = new ArrayList();
        ventes2.add(t2);
        e2.setVentes(ventes2);
        ArrayList<Transaction> ventes3 = new ArrayList();
        ventes3.add(t3);
        e3.setVentes(ventes3);
        
        assertEquals(200, galerie.CAannuel(2019), "Le CA annuel de 2019 doit être de 200€");
        assertEquals(160, galerie.CAannuel(2020), "Le CA annuel de 2020 doit être de 160€");
        
    }

}
