package galerie.entity;

import java.util.ArrayList;
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
    
    public Artiste( String nom, String adresse, String biographie){
        super(nom, adresse);
        this.biographie = biographie;
        this.oeuvres = new ArrayList<>();
    }
}
