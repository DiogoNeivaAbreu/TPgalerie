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

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy = "organisateur")
    private List<Exposition> evenements = new LinkedList<>();
    
    public Galerie(String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
        this.evenements = new LinkedList<>();
    }
    
    public float CAannuel(int annee){
        float result = 0;
        for( Exposition e : evenements){
            if(e.getDebut().equals(annee)){
                result += e.CA();
            }
        }
        return result;
    }
}
