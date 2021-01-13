package galerie.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.*;

@Getter @Setter @ToString(callSuper = true) @NoArgsConstructor @RequiredArgsConstructor 
@Entity // Une entité JPA
public class Artiste extends Personne{
    @Column(unique=true)
    @NonNull
    private String biographie;
    
    @OneToMany(mappedBy="auteur")
    private List<Tableau> oeuvres;
    
}
