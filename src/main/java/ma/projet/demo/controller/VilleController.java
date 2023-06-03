package ma.projet.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.demo.entities.Ville;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.repositories.VilleRepository;
import ma.projet.demo.repositories.ZoneRepository;

@RestController
@RequestMapping("/api/villes")
public class VilleController {
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private ZoneRepository zoneRepository;
	
	@PostMapping("/save")
	public void save(@RequestBody Ville ville) {
		villeRepository.save(ville);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Ville v = villeRepository.findById(Integer.parseInt(id));
		villeRepository.delete(v);
	}
	
	@GetMapping("/all")
	public List<Ville> findAll(){
		return villeRepository.findAll();
	}

	@GetMapping("/count")
	public long countVille(){
		return villeRepository.count();
	}
	
    @GetMapping("/{nom}/zones")
    public List<Zone> findByVille(@PathVariable String nom) {
        Ville ville = villeRepository.findByNom(nom);
        return zoneRepository.findByVille(ville);
    }
}
