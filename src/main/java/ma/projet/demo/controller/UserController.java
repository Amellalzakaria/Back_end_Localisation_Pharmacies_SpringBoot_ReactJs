package ma.projet.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.demo.entities.User;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.repositories.UserRepository;

@RestController
	@RequestMapping("/api/users")
	public class UserController {
		@Autowired
		private UserRepository userRepository;
		
		@PostMapping("/save")
		public void save(@RequestBody User user) {
			userRepository.save(user);
		}
		
		@DeleteMapping("/delete/{id}")
		public void delete(@PathVariable(required = true) String id) {
			User u = userRepository.findById(Integer.parseInt(id));
			userRepository.delete(u);
		}
		
		@GetMapping("/all")
		public List<User> findAll(){
			return userRepository.findAll();
		}
		
		@GetMapping("/count")
		public long countUser() {
			return userRepository.count();
		}
		

		@GetMapping("/byUser/{id}")
		public Collection<?> findByUser(@PathVariable (required = true) String id){
			User u = userRepository.findById(Integer.parseInt(id));
			return u.getRoles();
		}
		
	}

