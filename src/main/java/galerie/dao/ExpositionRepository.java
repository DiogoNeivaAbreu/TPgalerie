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
    @Query("SELECT SUM(t.prixVente) AS chiffreAffaire "
		+ "FROM Transaction t "
		+ "JOIN t.exposition e "
		+ "WHERE t.lieuDeVenteid =: e.id AND t.venduLe BETWEEN(e.debut,(e.debut+e.duree)) ")
    float chiffreAffairePour(Integer id);
}
