package ma.projet.demo.repositories;

import ma.projet.demo.entities.Garde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacieGardeRepository extends JpaRepository<Garde, Integer> {
}
