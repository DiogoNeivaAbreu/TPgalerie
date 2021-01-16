package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.Query;

public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {
    /**
     * Calculer le chiffre d'affaires pour une exposition
     * @param id la clé primaire de l'exposition
     * @return le chiffre d'affaires de cette exposition
     */
    @Query("SELECT SUM(v.prixVente) AS chiffreAffaire "
		+ "FROM Exposition e "
		+ "JOIN e.ventes v "
		+ "WHERE e.id = ?1 ")
    float chiffreAffairePour(Integer id);
}
