package galerie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

import galerie.entity.*;
import galerie.dao.*;

@Component
@Log4j2 // Génère le 'logger' pour afficher les messages de trace
public class ConsoleApp implements CommandLineRunner {

    @Autowired
    private ExpositionRepository expositionDAO;

    @Autowired
    private GalerieRepository galerieDAO;

    @Autowired
    private PersonneRepository personneDAO;

    @Override
    /*
     * Equivalent de la méthode 'main' pour une application Spring Boot
     **/
    public void run(String... args) throws Exception {
        
//        log.info("On liste tous les enregistrements de la table 'Galerie'");
//        for (Galerie g : galerieDAO.findAll()) {
//            System.out.println(g);
//        }
//
//        tapezEnterPourContinuer();
//
//        log.info("Recherche par clé");
//        Optional<Galerie> op = galerieDAO.findById(1);
//        op.ifPresent(p -> {
//            log.info("On a trouvé la galerie : {}", p);
//        });
//
//        tapezEnterPourContinuer();
//        
//        log.info("Démo de l'héritage en Spring-JPA");
//        // On crée des entités dans les sous-classes de 'Item'
//        Personne Jean = new Personne("Bidule", "Castres");
//        Artiste Pablo = new Artiste("Picasso", "Italie", "sabiographie");
//        // On les enregistre dans la base
//        personneDAO.save(Jean);
//        personneDAO.save(Pablo);
//        // On les retrouve dans les Item
//        personneDAO.findAll().forEach(System.out::println);

    }

    public static void tapezEnterPourContinuer() throws Exception {
        System.out.println("Tapez \"ENTER\" pour continuer...");
        System.in.read();
    }
}

