package ma.projet.demo.idao;

import java.util.List;

public interface IDao <T>{
		T save(T o);
		T update(T o);
		void delete(T o);
		long count();
		T findById(int id);
		List<T> findAll();
		
	}
