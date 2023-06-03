package ma.projet.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.Pharmacie;
import ma.projet.demo.entities.Zone;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer>{
	Pharmacie findById(int id);

	/*• Recherche des pharmacies par zone.*/
	
	 List<Pharmacie> findByZone(Zone zone); 
	 
	 
	/* List<Pharmacie> findByVilleAndZone(String ville, String zone);*/	 

	 /*List<Pharmacie> findByVilleAndZone(String ville, Zone zone);*/
	 
	 /*List<Pharmacie> findByZoneAndVille(String zone, String ville);*/
	
	 /* @Query("SELECT p FROM Pharmacie p WHERE p.zone.id = :zoneId AND p.zone.ville.id = :villeId")
	    Collection<Pharmacie> findPharmaciesByZoneAndVille(@Param("zoneId") int zoneId, @Param("villeId") int villeId);
		    */
	 
		 /*   List<Pharmacie> findByZoneAndVille(Zone zone, Ville ville); */
}
