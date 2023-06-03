package ma.projet.demo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Embeddable
public class PharmacieGardePk implements Serializable{
	private int pharmacie;
	private int garde;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	public PharmacieGardePk(int pharmacie, int garde, Date dateDebut) {
		super();
		this.pharmacie = pharmacie;
		this.garde = garde;
		this.dateDebut = dateDebut;
	}
	public PharmacieGardePk() {
		super();
	}
	public int getPharmacie() {
		return pharmacie;
	}
	public void setPharmacie(int pharmacie) {
		this.pharmacie = pharmacie;
	}
	public int getGarde() {
		return garde;
	}
	public void setGarde(int garde) {
		this.garde = garde;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
}
