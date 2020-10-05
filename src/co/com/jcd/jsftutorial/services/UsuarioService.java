package co.com.jcd.jsftutorial.services;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import co.com.jcd.jsftutorial.entities.Usuario;
import co.com.jcd.jsftutorial.repositories.UsuarioRepository;

public class UsuarioService implements IUsuarioService {
	
	private final UsuarioRepository repo = new UsuarioRepository();
	private static final UsuarioService INSTANCE = new UsuarioService();
	
	private UsuarioService() {
		// el constructor es privado para evitar que los usuarios
		// creen nuevas instancias
	}

	public static UsuarioService getInstance() {
		return INSTANCE;
	}
	
	public void save(Usuario obj) {
		if (obj != null) {
			obj.setCreatedAt(new Date());
			obj.setVerified("Si");
		}
		repo.save(obj);
	}
	
	public void update(Usuario obj) {
		repo.update(obj);
	}
	
	public void delete(Usuario obj) {
		repo.delete(obj);
	}
	
	public Optional<Usuario> getById(Integer id) {
		return repo.getById(id);
	}
	
	public List<Usuario> getAll() {
		return new LinkedList<>(repo.getAll());
	}

}
