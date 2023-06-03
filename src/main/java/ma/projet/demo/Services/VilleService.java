package ma.projet.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.entities.Ville;
import ma.projet.demo.idao.IDao;
import ma.projet.demo.repositories.VilleRepository;

	@Service
	public class VilleService implements IDao<Ville>{
		
		@Autowired
		VilleRepository villeRepository;
		
		@Override
		public Ville save(Ville o) {
			return villeRepository.save(o);
		}

		@Override
		public Ville update(Ville o) {
			// TODO Auto-generated method stub
			return villeRepository.save(o);
		}

		@Override
		public void delete(Ville o) {
			// TODO Auto-generated method stub
			villeRepository.delete(o);
			
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return villeRepository.count();
		}

		@Override
		public Ville findById(int id) {
			// TODO Auto-generated method stub
			return villeRepository.findById(id);
		}

		@Override
		public List<Ville> findAll() {
			// TODO Auto-generated method stub
			return villeRepository.findAll();
		}
}
