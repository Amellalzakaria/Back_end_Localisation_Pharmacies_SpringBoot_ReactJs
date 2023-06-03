package ma.projet.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.entities.Zone;
import ma.projet.demo.idao.IDao;
import ma.projet.demo.repositories.ZoneRepository;

@Service
	public class ZoneService implements IDao<Zone>{
		
		@Autowired
		ZoneRepository zoneRepository;
		@Override
		public Zone save(Zone o) {
			
			return zoneRepository.save(o);
		}

		@Override
		public Zone update(Zone o) {
			// TODO Auto-generated method stub
			return zoneRepository.save(o);
		}

		@Override
		public void delete(Zone o) {
			// TODO Auto-generated method stub
			zoneRepository.delete(o);
			
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return zoneRepository.count();
		}

		@Override
		public Zone findById(int id) {
			// TODO Auto-generated method stub
			return zoneRepository.findById(id);
		}

		@Override
		public List<Zone> findAll() {
			// TODO Auto-generated method stub
			return zoneRepository.findAll();
		}
		

	}
