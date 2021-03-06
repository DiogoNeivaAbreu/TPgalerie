package galerie.entity;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique = true)
    @NonNull
    private String nom;
    
    @Column(unique = true)
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy = "organisateur")
    private List<Exposition> evenements = new LinkedList<>();
    
    public Galerie(String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
        this.evenements = new LinkedList<>();
    }
    
    /**
     * Calculer le chiffre d'affaires pour une galerie
     * @param annee l'année du chiffre d'affaire
     * @return le chiffre d'affaires de cette galerie pour une année
     */
    public float CAannuel(int annee){
        float result = 0;
        for( Exposition e : evenements){
            if(e.getDebut().getYear() == annee){
                result += e.CA();
            }
        }
        return result;
    }
}
