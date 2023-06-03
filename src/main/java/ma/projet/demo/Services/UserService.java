package ma.projet.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.entities.User;
import ma.projet.demo.idao.IDao;
import ma.projet.demo.repositories.UserRepository;

@Service
	public class UserService implements IDao<User>{
		
		@Autowired
		UserRepository userRepository;
		@Override
		public User save(User o) {
			
			return userRepository.save(o);
		}

		@Override
		public User update(User o) {
			// TODO Auto-generated method stub
			return userRepository.save(o);
		}

		@Override
		public void delete(User o) {
			// TODO Auto-generated method stub
			userRepository.delete(o);
			
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return userRepository.count();
		}

		@Override
		public User findById(int id) {
			// TODO Auto-generated method stub
			return userRepository.findById(id);
		}

		@Override
		public List<User> findAll() {
			// TODO Auto-generated method stub
			return userRepository.findAll();
		}
		
		
		

	}
