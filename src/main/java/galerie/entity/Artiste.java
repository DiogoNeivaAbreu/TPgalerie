package galerie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.*;

@Getter @Setter @ToString(callSuper = true) @NoArgsConstructor @RequiredArgsConstructor 
@Entity // Une entité JPA
public class Artiste extends Personne{
    @Column(unique=true)
    @NonNull
    private String biographie;
    
}
