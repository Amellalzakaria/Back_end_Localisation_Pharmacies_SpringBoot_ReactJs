package ma.projet.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Zone {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	@ManyToOne
	private Ville ville;
	
	@JsonIgnore
	@OneToMany(mappedBy = "zone",fetch = FetchType.EAGER)
	private List<Pharmacie> pharmacies;
	public Zone() {
		super();
	}
	public Zone(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public List<Pharmacie> getPharmacies() {
		// TODO Auto-generated method stub
		return pharmacies;
	}
	public void setPharmacies(List<Pharmacie> pharmacies) {
		this.pharmacies = pharmacies;
	}

	
	
	
	
	
}
