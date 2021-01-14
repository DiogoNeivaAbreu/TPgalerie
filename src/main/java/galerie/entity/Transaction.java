package galerie.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Transaction {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idTransaction;
    
    @Column(unique=true)
    @NonNull
    private LocalDate venduLe;
    
    @Column(unique=true)
    @NonNull
    private float prixVente;
    
    @ManyToOne
    private Exposition lieuDeVente;
    
    @OneToOne
    private Tableau oeuvre;
    
    @ManyToOne
    private Personne client;
}
