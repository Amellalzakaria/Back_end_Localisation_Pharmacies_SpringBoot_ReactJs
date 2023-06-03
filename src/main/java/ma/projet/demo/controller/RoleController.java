package ma.projet.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.demo.entities.Role;
import ma.projet.demo.entities.User;
import ma.projet.demo.repositories.RoleRepository;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping("/save")
	public void save(@RequestBody Role role) {
		roleRepository.save(role);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) Integer id) {
		roleRepository.deleteById(id);
	}
	
	@GetMapping("/all")
	public List<Role> findAll(){
		return roleRepository.findAll();
	}
	
	@GetMapping("/count")
	public long countRoles() {
		return roleRepository.count();
	}
	
	@GetMapping("/byUser/{userId}")
	public List<Role> findByUser(@PathVariable Integer userId) {
		User user = new User();
		user.setId(userId);
		return roleRepository.findByUsers(user);
	}
}
