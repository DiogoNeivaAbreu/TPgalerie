package galerie.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Exposition {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private LocalDate debut;
    
    @Column(unique=true)
    @NonNull
    private String intitule;
    
    @Column(unique=true)
    @NonNull
    private int duree;
    
    @ManyToOne
    private Galerie organisateur;
    
    @OneToMany(mappedBy = "lieuDeVente")
	private List<Transaction> ventes = new LinkedList<>();
    
    @ManyToMany
    @JoinTable(name="expo_tableau",
    joinColumns = 
            @JoinColumn(name = "exposition_id", referencedColumnName="id"),
    inverseJoinColumns = 
            @JoinColumn(name = "tableau_id",  referencedColumnName="id")
    )            
    List<Tableau> oeuvres = new LinkedList<>();
    
    /**
     * Calculer le chiffre d'affaires pour une exposition
     * @return le chiffre d'affaires de cette exposition
     */
    public float CA(){
        float resultat = 0;
        for(Transaction v : ventes){
            resultat += v.getPrixVente();
        }
        return resultat;
    }
}
