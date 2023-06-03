package ma.projet.demo.entities;


import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class PharmacieGarde {
	@EmbeddedId
	PharmacieGardePk id;
	@Temporal(TemporalType.DATE)
	Date dateFin;
	@ManyToOne
	@JoinColumn(name = "pharmacie", insertable=false, updatable=false)
	private Pharmacie pharmacie;
	
	@ManyToOne
	@JoinColumn(name = "garde", insertable=false, updatable=false)
	private Garde garde;
	
	

	public PharmacieGarde() {
		super();
	}

	public PharmacieGarde(PharmacieGardePk id, Date dateFin, Pharmacie pharmacie, Garde garde) {
		super();
		this.id = id;
		this.dateFin = dateFin;
		this.pharmacie = pharmacie;
		this.garde = garde;
	}

	public PharmacieGardePk getId() {
		return id;
	}

	public void setId(PharmacieGardePk id) {
		this.id = id;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Garde getGarde() {
		return garde;
	}

	public void setGarde(Garde garde) {
		this.garde = garde;
	}
	
	

}

