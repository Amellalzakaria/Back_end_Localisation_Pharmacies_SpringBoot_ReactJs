package ma.projet.demo.repositories;

import ma.projet.demo.entities.Photo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Photo, Integer> {
	
	List<Photo> findByPharmacieId(int pharmacieId);
}
