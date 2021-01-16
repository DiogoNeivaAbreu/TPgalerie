package galerie.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import lombok.*;

@Getter @Setter @NoArgsConstructor @ToString
@Entity // Une entité JPA
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Personne {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @NonNull
    private String nom;
    
    @Column
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy ="client")
    private List<Transaction> achats;
    
    public Personne( String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
        this.achats = new ArrayList<>();
    }
    
    public float budgetArt(int annee){
        float budget = 0;
        for(Transaction a : achats){
            if(a.getVenduLe().getYear() == annee){
                budget += a.getPrixVente();
            }
        }
        return budget;
    }
}
