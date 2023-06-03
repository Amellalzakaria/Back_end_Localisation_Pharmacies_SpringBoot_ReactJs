package ma.projet.demo.repositories;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.projet.demo.entities.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {

	Ville findById(int id);
	Ville findByNom( String nom);
	

	
	/*@Query(value = "select * from Ville  where nom = :nom", nativeQuery = true)*/
//	@Query(value = "select * from Pharmacie p where p.zone_id = :id", nativeQuery = true)
//	Collection<?> findPharmaciesByZone(@Param("id") int id);
	
}


