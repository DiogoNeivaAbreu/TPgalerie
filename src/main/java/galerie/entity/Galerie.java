package galerie.entity;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idGalerie;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy = "organisateur", cascade = CascadeType.ALL)
    private List<Exposition> evenements = new LinkedList<>();
    
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
