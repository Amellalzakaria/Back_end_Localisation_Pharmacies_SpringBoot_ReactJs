package ma.projet.demo.Services;

import java.util.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.projet.demo.entities.Pharmacie;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.idao.IDao;
import ma.projet.demo.repositories.PharmacieRepository;

public class PharmacieService implements IDao<Pharmacie>{
	
	@Autowired
	PharmacieRepository pharmacieRepository;

	@Override
	public Pharmacie save(Pharmacie o) {
		return pharmacieRepository.save(o);
	}

	@Override
	public Pharmacie update(Pharmacie o) {
		return pharmacieRepository.save(o);
	}

	@Override
	public void delete(Pharmacie o) {
		pharmacieRepository.delete(o);
	}

	@Override
	public long count() {
		return pharmacieRepository.count();
	}

	@Override
	public Pharmacie findById(int id) {
		return pharmacieRepository.findById(id);
	}

	@Override
	public List<Pharmacie> findAll() {
		return pharmacieRepository.findAll();
	}

	public Collection<?> findByZone(Zone zone) {
		// TODO Auto-generated method stub
		return null;
	}


}
