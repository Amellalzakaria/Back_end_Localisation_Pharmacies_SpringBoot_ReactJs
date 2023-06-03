package ma.projet.demo.controller;

import java.util.Collection;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.demo.entities.Zone;
import ma.projet.demo.repositories.ZoneRepository;


@RestController
@RequestMapping("/api/zones")
public class ZoneController {
	@Autowired
	private ZoneRepository zoneRepository;
	
	@PostMapping("/save")
	public void save(@RequestBody Zone zone) {
		zoneRepository.save(zone);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Zone z = zoneRepository.findById(Integer.parseInt(id));
		zoneRepository.delete(z);
	}
	
	@GetMapping("/all")
	public List<Zone> findAll(){
		return zoneRepository.findAll();
	}
	
	@GetMapping("/count")
	public long countZone() {
		return zoneRepository.count();
	}
	

	@GetMapping("/byZone/{id}")
	public Collection<?> findByZone(@PathVariable (required = true) String id){
		Zone z = zoneRepository.findById(Integer.parseInt(id));
		return z.getPharmacies();
	}
	
}
