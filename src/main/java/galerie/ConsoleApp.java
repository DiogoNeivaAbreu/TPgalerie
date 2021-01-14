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

        tapezEnterPourContinuer();

        log.info("Recherche par clé");
        Optional<Galerie> op = galerieDAO.findById(1);
        op.ifPresent(p -> {
            log.info("On a trouvé la galerie : {}", p);
        });

        tapezEnterPourContinuer();

    }

    public static void tapezEnterPourContinuer() throws Exception {
        System.out.println("Tapez \"ENTER\" pour continuer...");
        System.in.read();
    }
}

