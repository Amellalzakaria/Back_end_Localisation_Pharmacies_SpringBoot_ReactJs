package ma.projet.demo.controller;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.demo.entities.Pharmacie;
import ma.projet.demo.entities.Ville;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.repositories.PharmacieRepository;
import ma.projet.demo.repositories.VilleRepository;
import ma.projet.demo.repositories.ZoneRepository;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacieController {
	@Autowired
	private PharmacieRepository pharmacieRepository;
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private ZoneRepository zoneRepository;

	@PostMapping("/save")
	public void save(@RequestBody Pharmacie pharmacie) {
		pharmacieRepository.save(pharmacie);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Pharmacie p = pharmacieRepository.findById(Integer.parseInt(id));
		pharmacieRepository.delete(p);
	}

	@GetMapping("/all")
	public List<Pharmacie> findAll() {
		return pharmacieRepository.findAll();
	}

	@GetMapping("/count")
	public long countPharmacie() {
		return pharmacieRepository.count();
	}

	/* • Recherche des pharmacies par zone. */

	@GetMapping("/byZone/{zoneId}")
	public List<Pharmacie> findByZone(@PathVariable int zoneId) {
		Zone zone = new Zone();
		zone.setId(zoneId);
		return pharmacieRepository.findByZone(zone);
	}

	/* Récupération de toutes les pharmacies pour une zone donnée */
	@GetMapping("/pharmacies/{zoneId}")
	public Collection<?> findPharmaciesByZone(@PathVariable int zoneId) {
		return pharmacieRepository.findByZone(new Zone(zoneId, null));
	}


	/* Récupération des détails d’une pharmacie */
	@GetMapping("/{id}")
	public ResponseEntity<Pharmacie> getPharmacieById(@PathVariable(value = "id") int pharmacieId)
			throws ResourceNotFoundException {
		Pharmacie pharmacie = pharmacieRepository.findById(pharmacieId);
		if (pharmacie == null) {
			throw new ResourceNotFoundException("Pharmacie not found for this id :: " + pharmacieId);
		}
		return ResponseEntity.ok().body(pharmacie);
	}

	/* 3 */

	@GetMapping("/zones/{zoneid}/pharmacies")
	public List<Pharmacie> findPharmacieByVilleAndZone(@PathVariable(required = true) String zone) {
		Zone z = zoneRepository.findById(Integer.parseInt(zone));
		return z.getPharmacies();
	}

	
	/* 6 */
	@GetMapping("/{id}/itineraire")
	public String getItineraire(@PathVariable int id, @RequestParam String depart) {
		Pharmacie pharmacie = pharmacieRepository.findById(id);
		if (pharmacie == null) {
			throw new ResourceNotFoundException("Pharmacie not found with id " + id);
		}
		String itineraire = getItineraireFromApi(depart, pharmacie.getAdresse());
		return itineraire;
	}

	private String getItineraireFromApi(String depart, String destination) {

		return "Itinéraire de " + depart + " à " + destination;
	}

}



/*
 * @GetMapping("/{ville}/zones/{zone}/pharmacies") public List<Pharmacie>
 * getPharmaciesByVilleAndZone(@PathVariable String ville, @PathVariable String
 * zone) { return pharmacieRepository.findByVilleAndZone(ville, zone); }
 */
/*
 * @GetMapping("/villes/{ville}/zones/{zone}/pharmacies") public List<Pharmacie>
 * findByVilleAndZone(@PathVariable String ville, @PathVariable int zone) {
 * return pharmacieRepository.findByVilleAndZone(ville, new Zone(zone, null)); }
 */
/*
 * @GetMapping("/{zone}/{ville}") public List<Pharmacie>
 * findByZoneAndVille(@PathVariable String zone, @PathVariable String ville) {
 * return pharmacieRepository.findByZoneAndVille(zone, ville); }
 */
